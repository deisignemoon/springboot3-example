package com.xiacong.config;

import cn.hutool.core.lang.Assert;
import com.alibaba.fastjson2.JSONObject;
import com.xiacong.common.filter.RequestWrapper;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Slf4j
@Component
@Order(2)
public class SignatureValidationFilter extends OncePerRequestFilter {
    //@Resource
    //private SysMerchantService merchantService;


    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String servletPath = request.getServletPath();
        // 只对api开头的商家接口请求进行签名验证
        if (!servletPath.startsWith("/api")) {
            chain.doFilter(request, response);
            return;
        }
        RequestWrapper requestWrapper = new RequestWrapper(request);
        String signature = requestWrapper.getHeader("X-Signature");
        String timestamp = requestWrapper.getHeader("X-Timestamp");
        String merchantNo = requestWrapper.getHeader("X-merchant");
        requestWrapper.getInputStream();
        String body = new String(requestWrapper.getRequestBody());
        body = paramSort(JSONObject.parseObject(body));
        if (StringUtils.isBlank(signature) || StringUtils.isBlank(timestamp) || StringUtils.isBlank(merchantNo) || StringUtils.isBlank(body)) {
            throw new AuthenticationException("Missing signature, timestamp,merchant, or body") {
            };
        }

        if (!isValidSignature(merchantNo, signature, timestamp, body)) {
            throw new AuthenticationException("Invalid signature") {
            };
        }
        CustomAuthenticationToken token = new CustomAuthenticationToken();
        token.setMerchantNo(merchantNo);
        SecurityContextHolder.getContext().setAuthentication(token);
        chain.doFilter(request, response);
    }

    public boolean isValidSignature(String merchantNo, String signature, String timestamp, String body) {
        //SysMerchant merchant = merchantService.findByMerchantNo(merchantNo);
        //Assert.isNull(merchant, () -> new ServiceException(SystemCodeInfo.MERCHANT_NOT_EXIST));
        //Assert.isTrue(StringUtils.equals(merchant.getStatus(), CommonConstant.ABLED), () -> new ServiceException(SystemCodeInfo.MERCHANT_IS_DISABLE));
        //String secretKey = merchant.getAppSecret(); // 替换为实际的密钥
        //String data = merchantNo + timestamp + body;
//
        //try {
        //    Mac sha256Hmac = Mac.getInstance("HmacSHA256");
        //    SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        //    sha256Hmac.init(secretKeySpec);
        //    byte[] hmacBytes = sha256Hmac.doFinal(data.getBytes(StandardCharsets.UTF_8));
        //    String calculatedSignature = Base64.getEncoder().encodeToString(hmacBytes);
        //    return calculatedSignature.equals(signature);
        //} catch (NoSuchAlgorithmException | InvalidKeyException e) {
        //    log.error("Error validating signature：{}", e.getMessage());
        //    return false;
        //}
        return true;
    }

    public String sign(String merchantNo,String secretKey, String timestamp, String body) {
        String data = merchantNo + timestamp + body;
        try {
            Mac sha256Hmac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
            sha256Hmac.init(secretKeySpec);
            byte[] hmacBytes = sha256Hmac.doFinal(data.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hmacBytes);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            log.error("Error validating signature：{}", e.getMessage());
            return null;
        }
    }

    private String paramSort(Map<String, Object> params) {
        //将params的参数按照字典序排序，key,value使用=连接，参数间使用&连接
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>(params.keySet());
        Collections.sort(list);
        for (String key : list) {
            Object value = params.get(key);
            if (null != value) {
                if (value instanceof String) {
                    value = ((String) value).trim();
                } else {
                    value = JSONObject.toJSONString(value);
                }
                sb.append(key).append("=").append(value).append("&");
            }
        }
        return sb.toString();
    }
}
