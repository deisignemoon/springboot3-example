package com.xiacong.listener;

import com.xiacong.cache.impl.CacheManagerRegister;
import com.xiacong.event.VirtualTableCacheRefershFinishEvent;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 缓存刷新监听器
 *
 * @author xiacong
 * @Classname CacheRefershListener
 * @Version 1.0.0
 * @Date 2023/10/19 16:19
 * @Created by xiacong
 */
@Component
@Slf4j
@Order(0)
public class CacheRefershListener implements ApplicationListener<ApplicationStartedEvent> {

    @Resource
    private CacheManagerRegister cacheManagerRegister;


    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        log.info("启动时缓存刷新开始");
        cacheManagerRegister.refershAll();
        log.info("启动时缓存刷新结束");
    }
}
