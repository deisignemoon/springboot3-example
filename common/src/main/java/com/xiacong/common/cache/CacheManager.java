package com.xiacong.common.cache;

import java.util.List;

/**
 * @Classname CacheManager
 * @Version 1.0.0
 * @Date 2023/6/21 13:34
 * @Created by xiacong
 */
public interface CacheManager<T> {
    /**
     * 初始化缓存
     */
    void init();

    /**
     * 查询数据库所有数据
     *
     * @return
     */
    List<T> findAll();

    /**
     * 清理所有缓存
     */
    void clear();

    /**
     * 刷新所有缓存
     */
    void refersh();

}
