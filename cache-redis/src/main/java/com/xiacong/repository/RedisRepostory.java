package com.xiacong.repository;

import com.xiacong.common.repository.Repository;
import com.xiacong.model.aggreate.RedisAggreate;

/**
 * @author xiacong
 * @Classname RedisRepostiry
 * @Version 1.0.0
 * @Date 2024/4/19 10:17
 * @Created by xiacong
 */
public interface RedisRepostory extends Repository<RedisAggreate<Object>> {

    /**
     * 自增
     *
     * @param key
     * @return
     */
    Long increment(String key);

    /**
     * 自减
     *
     * @param key
     * @return
     */
    Long decrement(String key);

    void putMap(RedisAggreate<Object> aggregate);

    Object getMap(String redisKey, Object mapKey);


}
