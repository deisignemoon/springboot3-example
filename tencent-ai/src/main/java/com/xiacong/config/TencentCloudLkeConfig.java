package com.xiacong.config;

import com.tencentcloudapi.common.Credential;
import com.xiacong.utils.tencent.HttpSSE;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 *
 * @author xiacong
 * @Classname TencentCloudLkeConfig
 * @Version 1.0.0
 * @Date 2025/4/17 13:04
 * @Created by xiacong
 */
@Configuration
public class TencentCloudLkeConfig {

    @Value("${tencent.cloud.lke.appkey}")
    public String APPKEY;
    @Value("${tencent.cloud.lke.secretid}")
    public String SECRETID;
    @Value("${tencent.cloud.lke.secretkey}")
    public String SECRETKEY;
    @Value("${tencent.cloud.lke.sseurl}")
    public String SSEURL;

    @Bean
    public HttpSSE httpSSE(){
        HttpSSE httpSSE = new HttpSSE();
        httpSSE.setAppKey(APPKEY);
        httpSSE.setSseUrl(SSEURL);
        return httpSSE;
    }

    @Bean
    public Credential getCredential(){
        return new Credential(SECRETID, SECRETKEY);
    }
}
