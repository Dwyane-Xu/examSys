package com.github.dwyane.mobile;

import com.github.dwyane.event.CustomAuthenticationFailureEvent;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @ClassNanme: MobileAuthenticationProvider
 * @Description: 手机登录提供者
 * @Author: xujinzhao
 * @Date: 2020/2/20 11:49
 */
@Slf4j
@Data
public class MobileAuthenticationProvider {

//    implements AuthenticationProvider

    /*
    private MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();

    private CustomUserDetailsService customUserDetailsService;

    private ApplicationEventPublisher publisher;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        MobileAuthenticationToken mobileAuthenticationToken = (MobileAuthenticationToken) authentication;
        String principal = mobileAuthenticationToken.getPrincipal().toString();
        UserDetails userDetails = customUserDetailsService.loadUserBySocialAndTenantCode(TenantContextHolder.getTenantCode(), principal, mobileAuthenticationToken.getMobileUser());
        if (userDetails == null) {
            log.debug("Authentication failed: no credentials provided");
            publisher.publishEvent(new CustomAuthenticationFailureEvent(authentication, userDetails));
            throw new BadCredentialsException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.noopBindAccount", "Noop Bind Account"));
        }
        MobileAuthenticationToken authenticationToken = new MobileAuthenticationToken(userDetails, userDetails.getAuthorities());
        authenticationToken.setDetails(mobileAuthenticationToken.getDetails());
        publisher.publishEvent(new CustomAuthenticationSuccessEvent(authentication, userDetails));
        return authenticationToken;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return MobileAuthenticationToken.class.isAssignableFrom(authentication);
    }
    */
}
