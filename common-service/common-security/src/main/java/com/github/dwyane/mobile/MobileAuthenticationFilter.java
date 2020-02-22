package com.github.dwyane.mobile;

import com.github.dwyane.constant.SecurityConstant;
import com.github.dwyane.util.GsonUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassNanme: MobileAuthenticationFilter
 * @Description: 手机登录过滤器
 * @Author: xujinzhao
 * @Date: 2020/2/20 11:29
 */
@Slf4j
public class MobileAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    @Getter
    @Setter
    private String mobileParameter = SecurityConstant.MOBILE_TOKEN_URL;

    @Getter
    @Setter
    private boolean postOnly = true;

    @Getter
    @Setter
    private AuthenticationEventPublisher eventPublisher;

    @Getter
    @Setter
    private AuthenticationEntryPoint authenticationEntryPoint;

    public MobileAuthenticationFilter() {
        super(new AntPathRequestMatcher(SecurityConstant.MOBILE_TOKEN_URL, HttpMethod.POST.name()));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (postOnly && !request.getMethod().equals(HttpMethod.POST.name())) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        // 获取手机登录的参数
        String mobile = obtainMobile(request);
        if (mobile == null) {
            mobile = "";
        }
        mobile = mobile.trim();
        // 封装成token
        MobileAuthenticationToken mobileAuthenticationToken = new MobileAuthenticationToken(mobile);
        // 封装其它基本信息
        setMobileUserDetails(request, mobileAuthenticationToken);
        setDetails(request, mobileAuthenticationToken);
        Authentication authResult = null;
        try {
            // 认证
            authResult = this.getAuthenticationManager().authenticate(mobileAuthenticationToken);
            logger.debug("Authentication success: " + authResult);
            // 认证成功
            eventPublisher.publishAuthenticationSuccess(authResult);
            SecurityContextHolder.getContext().setAuthentication(authResult);
        } catch (Exception failed) {
            SecurityContextHolder.clearContext();
            logger.debug("Authentication request failed: " + failed);
            eventPublisher.publishAuthenticationFailure(new BadCredentialsException(failed.getMessage(), failed), new PreAuthenticatedAuthenticationToken("access-token", "N/A"));
            try {
                authenticationEntryPoint.commence(request, response, new UsernameNotFoundException(failed.getMessage(), failed));
            } catch (Exception e) {
                logger.error("authenticationEntryPoint handle error:{}", failed);
            }
        }
        return authResult;
    }

    private String obtainMobile(HttpServletRequest request) {
        return request.getParameter(mobileParameter);
    }

    private void setDetails(HttpServletRequest request, MobileAuthenticationToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }

    /**
     * 设置姓名、性别、头像等信息
     *
     * @param request     request
     * @param authRequest authRequest
     */
    private void setMobileUserDetails(HttpServletRequest request, MobileAuthenticationToken authRequest) {
        try {
            String result = IOUtils.toString(request.getReader());
            if (StringUtils.isNotBlank(result)) {
                MobileUser user = GsonUtil.getInstance().fromJson(result, MobileUser.class);
                authRequest.setMobileUser(user);
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}
