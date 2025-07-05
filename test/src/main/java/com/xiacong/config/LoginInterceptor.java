package com.xiacong.config;

import com.xiacong.model.ThreeInfo;
import com.xiacong.service.ThreeInfoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * 登陆拦截器
 *
 * @author fyc
 */
public class LoginInterceptor implements HandlerInterceptor {

    private static Logger LOG = LoggerFactory.getLogger(LoginInterceptor.class);

    //todo 新增三方鉴权服务
    private ThreeInfoService threeInfoService;

    private static final String HMACSHA256 = "HmacSHA256";

    public LoginInterceptor(ThreeInfoService threeInfoService) {
        this.threeInfoService = threeInfoService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOG.info("鉴权开始");
        //三方鉴权
        return threeInfoCheck(request, response, handler);
    }

    private boolean threeInfoCheck(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String key = request.getHeader("key");
        if (StringUtils.isBlank(key)) {
            throw new RuntimeException("THREE_KEY_EMPTY");
        }
        ThreeInfo threeInfo = threeInfoService.getThreeInfoByKey(key);
        if (threeInfo == null || StringUtils.equals(threeInfo.getStatus(), "1")) {
            throw new RuntimeException("THREE_EMPTY");
        }
        String sign = request.getHeader("sign");
        if (StringUtils.isBlank(sign)) {
            throw new RuntimeException("THREE_SIGN_EMPTY");
        }
        String timestamp = request.getHeader("timestamp");
        if (StringUtils.isBlank(timestamp)) {
            throw new RuntimeException("THREE_TIMESTAMP_EMPTY");
        }
        return verifyThree(key, threeInfo.getThreeSecret(), timestamp, sign);
    }

    /**
     * 三方验签
     * @param key
     * @param threeSecret
     * @param timestamp
     * @param sign
     * @return
     */
    private boolean verifyThree(String key, String threeSecret, String timestamp, String sign) {
        LOG.info("key:{},sign:{},timestamp:{}", key, sign, timestamp);
        String body = key + timestamp;
        try {
            Mac hmac = Mac.getInstance(HMACSHA256);
            SecretKeySpec secretKeySpec = new SecretKeySpec(threeSecret.getBytes(StandardCharsets.UTF_8), HMACSHA256);
            hmac.init(secretKeySpec);
            byte[] bytes = hmac.doFinal(body.getBytes(StandardCharsets.UTF_8));
            String ver = Base64.getEncoder().encodeToString(bytes);
            if (StringUtils.equals(ver, sign)) {
                return true;
            }
        } catch (Exception e) {
            LOG.error("verifyThree error {}", e.getMessage());
            throw new RuntimeException(e);
        }
        return false;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

}
