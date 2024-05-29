package com.xiacong.common.cache;

/**
 * @Classname AbstractCacheManager
 * @Version 1.0.0
 * @Date 2023/6/21 13:37
 * @Created by 您好
 */
public abstract class AbstractCacheManager<T> implements CacheManager<T>{

    @Override
    public void refersh() {
        clear();
        init();
    }
}
