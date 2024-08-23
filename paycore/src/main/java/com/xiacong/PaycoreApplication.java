package com.xiacong;


import com.xiacong.common.util.TraceIdUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author xiacong
 * @Date ${DATE}
 */
@SpringBootApplication
@MapperScan("com.xiacong.mapper")
@Slf4j
@EnableDubbo
@EnableDiscoveryClient
@EnableScheduling
@ServletComponentScan
public class PaycoreApplication {
    public static void main(String[] args) {
        TraceIdUtil.setTraceId();
        ConfigurableApplicationContext run = SpringApplication.run(PaycoreApplication.class, args);
        if (run.isActive()) {
            log.info("paycore 服务启动成功");
        }
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.info("paycore 服务关闭");
        }));
    }
}