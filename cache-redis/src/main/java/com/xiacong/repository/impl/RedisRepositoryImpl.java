package com.xiacong.repository.impl;

import com.xiacong.common.converter.RedissionConverter;
import com.xiacong.model.aggreate.RedisAggreate;
import com.xiacong.repository.RedisRepostory;
import com.xiacong.util.RedissonUtil;
import jakarta.annotation.Resource;
import org.redisson.api.RMapCache;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author xiacong
 * @Classname RedisRepositoryImpl
 * @Version 1.0.0
 * @Date 2024/4/19 10:24
 * @Created by xiacong
 */
@Component
public class RedisRepositoryImpl implements RedisRepostory {

    @Resource
    private RedissonUtil redissonUtil;
    @Resource
    private RedissionConverter converter;

    @Override
    public RedisAggreate<Object> find(String id) {
        Object value = redissonUtil.get(id);
        return converter.convert(id, value);
    }

    @Override
    public void remove(RedisAggreate<Object> aggregate) {
        redissonUtil.remove(aggregate.getKey());
    }

    @Override
    public void save(RedisAggreate<Object> aggregate) {
        redissonUtil.put(aggregate.getKey(), aggregate.getValue());
    }

    @Override
    public Long increment(String key) {
        return redissonUtil.increment(key);
    }

    @Override
    public Long decrement(String key) {
        return redissonUtil.decrement(key);
    }

    @Override
    public void putMap(RedisAggreate<Object> aggregate) {
        RMapCache<Object, Object> map = redissonUtil.getRedisMap(aggregate.getKey());
        map.putAll((Map<?, ?>) aggregate.getValue());
    }

    @Override
    public Object getMap(String redisKey, Object mapKey) {
        RMapCache<Object, Object> map = redissonUtil.getRedisMap(redisKey);
        return map.get(mapKey);
    }
}
