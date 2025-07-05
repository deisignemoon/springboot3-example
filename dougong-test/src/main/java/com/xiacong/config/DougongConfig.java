package com.xiacong.config;

import com.huifu.bspay.sdk.opps.core.BasePay;
import com.huifu.bspay.sdk.opps.core.config.MerConfig;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 *
 * @author xiacong
 * @Classname DougongConfig
 * @Version 1.0.0
 * @Date 2025/4/25 9:07
 * @Created by xiacong
 */
@Configuration
@Getter
public class DougongConfig {
    @Value("${dougong.wx_appid}")
    private String wxAppid;
    @Value("${dougong.sys_id}")
    private String sysId;
    @Value("${dougong.product_id}")
    private String productId;
    @Value("${dougong.custom_socket_timeout}")
    private String customSocketTimeout;
    @Value("${dougong.custom_connect_timeout}")
    private String customConnectTimeout;
    @Value("${dougong.custom_connection_request_timeout}")
    private String customConnectionRequestTimeout;
    @Value("${dougong.merchant_private_key}")
    private String merchantPrivateKey;
    @Value("${dougong.merchant_public_key}")
    private String merchantPublicKey;
    @Value("${dougong.huifu_public_key}")
    private String huifuPublicKey;
    @Value("${dougong.debug}")
    private Boolean debug;
    @Value("${dougong.env}")
    private String env;
    @Value("${dougong.merchant_id}")
    private String merchantId;
    @Value("${dougong.notify_url}")
    private String notifyUrl;


    @Bean
    public MerConfig getMerConfig() throws Exception {
        MerConfig merConfig = new MerConfig();
        merConfig.setProcutId(productId);
        merConfig.setSysId(sysId);
        merConfig.setRsaPrivateKey(merchantPrivateKey);
        merConfig.setRsaPublicKey(huifuPublicKey);
        //自定义超时时间
        merConfig.setCustomSocketTimeout(customSocketTimeout);
        merConfig.setCustomConnectTimeout(customConnectTimeout);
        merConfig.setCustomConnectionRequestTimeout(customConnectionRequestTimeout);
        //debug 模式，开启后有详细的日志
        BasePay.debug = debug;
        BasePay.prodMode = env;
        BasePay.addMerConfig(merConfig,sysId);
        return merConfig;
    }
}
