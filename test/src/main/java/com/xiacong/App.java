package com.xiacong;

import com.xiacong.common.util.TraceIdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
@ServletComponentScan
public class App {
    public static void main(String[] args) {
        TraceIdUtil.setTraceId();
        ConfigurableApplicationContext run = SpringApplication.run(App.class, args);
        if (run.isActive()) {
            log.info("test 服务启动成功");
        }
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.info("test 服务关闭");
        }));
    }
}
