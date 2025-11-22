//package com.xiacong.config;
//
//import com.xiacong.util.suqi.SuZhouBusUtil;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// *
// *
// * @author xiacong
// * @Classname SuqiConfig
// * @Version 1.0.0
// * @Date 2025/6/3 16:05
// * @Created by xiacong
// */
//@Configuration
//public class SuqiConfig {
//    @Value("${suqi.url}")
//    public String url;
//    @Value("${suqi.key}")
//    public String key;
//    @Value("${suqi.channel}")
//    public String channel;
//
//    @Bean
//    public SuZhouBusUtil getSuZhouBusUtil() {
//        return new SuZhouBusUtil(url, key, channel);
//    }
//
//}
