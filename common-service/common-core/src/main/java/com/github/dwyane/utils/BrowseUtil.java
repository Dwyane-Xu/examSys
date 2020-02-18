package com.github.dwyane.utils;


import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @ClassNanme: BrowseUtil
 * @Description: 浏览器工具类
 * @Author: xujinzhao
 * @Date: 2020/2/17 21:57
 */
public class BrowseUtil {

    /**
     * 获取在不同浏览器下的下载文件的转码规则
     *
     * @param request  request
     * @param fileName 原名，不进行转码前名称
     * @return String 示例 "filename=\"" + downloadName + "\"";
     */
    public static String getDownName(HttpServletRequest request, String fileName) {
        String result = "";
        String httpUserAgent = request.getHeader("User-Agent");
        try {
            if (StringUtils.isNotEmpty(httpUserAgent)) {
                String downloadName = URLEncoder.encode(fileName, "UTF-8");
                httpUserAgent = httpUserAgent.toLowerCase();
                if (httpUserAgent.contains("msie")) {
                    result = "attachment;filename=\"" + downloadName + "\"";
                } // Opera浏览器只能采用filename*
                else if (httpUserAgent.contains("opera")) {
                    result = "attachment;filename*=UTF-8''" + downloadName;
                } else if (httpUserAgent.contains("trident") || httpUserAgent.contains("edge")) {
                    result = "attachment;filename=\"" + URLEncoder.encode(fileName, "UTF-8");
                }
                // Chrome浏览器，只能采用MimeUtility编码或ISO编码的中文输出
                else if (httpUserAgent.contains("applewebkit")) {
                    result = "attachment;filename=\"" + downloadName + "\"";
                }
                // FireFox浏览器，可以使用MimeUtility或filename*或ISO编码的中文输出
                else if (httpUserAgent.contains("mozilla")) {
                    result = "attachment;filename*=UTF-8''" + downloadName;
                } else {
                    result = "attachment;filename=\"" + downloadName + "\"";
                }
            }
        } catch (UnsupportedEncodingException e) {
            result = "attachment;filename=\"" + fileName + "\"";
        }
        return result;
    }
}
