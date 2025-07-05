package com.xiacong.util;


import com.alibaba.fastjson2.JSONObject;
import com.alipay.v3.ApiClient;
import com.alipay.v3.ApiException;
import com.alipay.v3.Configuration;
import com.alipay.v3.api.AlipaySystemOauthApi;
import com.alipay.v3.api.AlipayUserInfoApi;
import com.alipay.v3.api.AlipayUserUserinfoApi;
import com.alipay.v3.model.*;
import com.alipay.v3.util.model.AlipayConfig;
import com.alipay.v3.util.model.CustomizedParams;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;

import java.util.Date;

/**
 *
 *
 * @author xiacong
 * @Classname AliUtil
 * @Version 1.0.0
 * @Date 2025/3/20 13:46
 * @Created by xiacong
 */
@Slf4j
public class AliConfig {
    //应用私钥
    private String privateKey = "应用私钥";
    //支付宝公钥
    private String alipayPublicKey = "支付宝公钥 ";
    private String serverUrl = "https://openapi.alipay.com";
    private String appId = "支付宝appId";


    private AlipayConfig getAlipayConfig() {
        AlipayConfig alipayConfig = new AlipayConfig();
        alipayConfig.setServerUrl(serverUrl);
        alipayConfig.setAppId(appId);
        alipayConfig.setPrivateKey(privateKey);
        alipayConfig.setAlipayPublicKey(alipayPublicKey);
        return alipayConfig;
    }


    public ApiClient alipayClient() {
        ApiClient alipayClient = null;
        try {
            alipayClient = Configuration.getDefaultApiClient();
            // 初始化alipay参数（全局设置一次）
            alipayClient.setAlipayConfig(getAlipayConfig());
        } catch (Exception e) {
            log.error("支付宝初始化失败");
            throw new RuntimeException(e);
        }
        return alipayClient;
    }

    public AlipaySystemOauthTokenResponseModel getAccessTokenByAuthCode(String authCode) {
        // 构造请求参数以调用接口
        AlipaySystemOauthApi api = new AlipaySystemOauthApi();
        AlipaySystemOauthTokenModel data = new AlipaySystemOauthTokenModel();
        String grantType = null;
        //如果缓存为空，或者则refreshToken过期，使用 authorization_code
        //if (StringUtils.isBlank(accessToken) || accessTokenExpiresTime.before(new Date())) {
        //    grantType = "authorization_code";
        //} else {
        //    grantType = "refresh_token";
        //    data.setRefreshToken(refreshToken);
        //}
        grantType = "authorization_code";
        // 设置授权码
        data.setCode(authCode);
        // 设置授权方式
        data.setGrantType(grantType);
        AlipaySystemOauthTokenResponseModel response = null;
        try {
            response = api.token(data);
        } catch (ApiException e) {
            AlipaySystemOauthTokenDefaultResponse errorObject = (AlipaySystemOauthTokenDefaultResponse) e.getErrorObject();
            log.error("支付宝授权失败{}", errorObject.getAlipaySystemOauthTokenErrorResponseModel().getMessage());
            throw new RuntimeException(e);
        }
        log.info("获取accessToken成功{}", JSONObject.toJSONString(response));
        return response;
    }

    private AlipayUserInfoShareResponseModel getUserInfo(String authToken) {
        // 构造请求参数以调用接口
        AlipayUserInfoApi api = new AlipayUserInfoApi();
        // 第三方代调用模式下请设置app_auth_token
        CustomizedParams params = new CustomizedParams();
        params.setAppAuthToken("<-- 请填写应用授权令牌 -->");

        try {
            AlipayUserInfoShareResponseModel response = api.share(authToken, params);
        } catch (ApiException e) {
            AlipayUserInfoShareDefaultResponse errorObject = (AlipayUserInfoShareDefaultResponse) e.getErrorObject();
            System.out.println("调用失败:" + errorObject);
        }
        return null;
    }
}
