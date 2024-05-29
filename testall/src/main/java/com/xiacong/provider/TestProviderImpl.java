package com.xiacong.provider;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

/**
 * @author xiacong
 * @Classname TestProviderImpl
 * @Version 1.0.0
 * @Date 2023/10/26 15:49
 * @Created by xiacong
 */
@Service
@DubboService
@Slf4j
public class TestProviderImpl implements TestProvider {
    @Override
    public String hello() {
        log.info("开始dubbo调用");
        return "Hello";
    }
}
