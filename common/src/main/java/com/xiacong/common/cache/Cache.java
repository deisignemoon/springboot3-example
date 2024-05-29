package com.xiacong.common.cache;

/**
 * @Classname Cache
 * @Version 1.0.0
 * @Date 2023/6/21 13:39
 * @Created by 您好
 */
public interface Cache<T> {
    /**
     * 获得一条缓存
     * @param key
     * @return
     */
    T get(String key);

    /**
     * 新增一条缓存
     * @param key
     * @param value
     * @return
     */
    Boolean add(String key ,T value);

    /**
     * 删除一条缓存
     * @param key
     * @return
     */
    T remove(String key);

    /**
     * 更新一条缓存
     * @param key
     * @param value
     * @return
     */
    Boolean update(String key,T value);

    /**
     * 删除所有缓存
     * @return
     */
    Boolean removeAll();

    /**
     * 获取key
     * @param obj
     * @return
     */
    String getKey(T obj);
}
