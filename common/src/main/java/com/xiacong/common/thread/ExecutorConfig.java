/**
 * @(#)ExecutorConfig.java, 6月 29, 2021.
 * <p>
 * Copyright 2021 pingge.com. All rights reserved.
 * PINGHANG.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.xiacong.common.thread;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池
 * @date 2023/6/7 13:40
 * @author yue
 */

@Configuration
@EnableAsync
public class ExecutorConfig {

    private int corePoolSize = 10;
    private int maxPoolSize = 50;
    private int queueCapacity = 10;
    @Bean("controlAsync")
    public Executor controlAsync() {
        MdcThreadPoolTaskExecutor executor = new MdcThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix("异步处理线程-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

}
