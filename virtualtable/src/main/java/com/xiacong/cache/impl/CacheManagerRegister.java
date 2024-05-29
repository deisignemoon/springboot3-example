package com.xiacong.cache.impl;

import com.xiacong.common.cache.CacheManager;
import com.xiacong.event.VirtualTableCacheRefershFinishEvent;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Classname CacheManagerRegister
 * @Description 缓存管理器注册中心
 * @Version 1.0.0
 * @Date 2023/6/25 8:30
 * @Created by 您好
 */
@Component
@Slf4j
public class CacheManagerRegister {

    @Value("${cache.values}")
    private List<String> refershCacheName;

    //@Value("${cache.table}")
    //private List<String> refershTableName;

    @Resource
    private Map<String, CacheManager> register = new ConcurrentHashMap<>();

    @Resource
    private ApplicationEventPublisher eventPublisher;

    public void refershAll() {
        if (CollectionUtils.isEmpty(refershCacheName)) {
            log.debug("不缓存虚拟表数据");
            return;
        }
        for (String cacheName : refershCacheName) {
            CacheManager value = register.get(cacheName);
            log.info("缓存{}刷新开始", cacheName);
            try {
                value.refersh();
            } catch (Exception e) {
                e.printStackTrace();
                log.error("缓存{}，刷新异常，e:{}", cacheName, e.getStackTrace());
            }
            log.info("缓存{}刷新成功", cacheName);
        }
        eventPublisher.publishEvent(new VirtualTableCacheRefershFinishEvent(refershCacheName));
    }

    public void refersh(String cacheName) {
        if (StringUtils.isBlank(cacheName)) {
            return;
        }
        CacheManager manager = register.get(cacheName);
        log.info("缓存{}刷新开始", cacheName);
        try {
            manager.refersh();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("缓存{}，刷新异常，e:{}", cacheName, e.getStackTrace());
        }
        log.info("缓存{}，刷新成功", cacheName);

    }
}
