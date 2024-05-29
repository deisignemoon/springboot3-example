package com.xiacong.util;

import com.xiacong.common.constant.RedisConstant;
import jakarta.annotation.Resource;
import org.redisson.api.*;
import org.redisson.client.codec.StringCodec;
import org.redisson.client.protocol.RedisCommand;
import org.redisson.client.protocol.RedisCommands;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.time.Duration;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author
 */
@Component
public class RedissonUtil {

    @Resource
    private RedissonClient redisson;

    /**
     * 默认过期时间，不过期
     */
    private static final long DEFAULT_EXPIRED = 0L;


    /**
     * 读取缓存
     *
     * @param key 缓存key
     * @param <T>
     * @return 缓存返回值
     */
    public <T> T get(String key) {
        RBucket<T> bucket = redisson.getBucket(RedisConstant.REDIS_KEY_PREFIX + key);
        return bucket.get();
    }

    /**
     * 以string的方式读取缓存
     *
     * @param key 缓存key
     * @return 缓存返回值
     */
    public String getString(String key) {
        RBucket<String> bucket = redisson.getBucket(RedisConstant.REDIS_KEY_PREFIX + key, StringCodec.INSTANCE);
        return bucket.get();
    }

    /**
     * 模糊查询key
     * @param pattern
     * @return
     */
    public Set<String> getKeys(String pattern) {
        RKeys keys = redisson.getKeys();
        Iterable<String> keysByPattern = keys.getKeysByPattern(pattern);
        Set<String> patternKeys = new HashSet<>();
        for (String string : keysByPattern) {
            patternKeys.add(string);
        }
        return patternKeys;
    }

    /**
     * 设置缓存（注：redisson会自动选择序列化反序列化方式）
     *
     * @param key   缓存key
     * @param value 缓存值
     * @param <T>
     */
    public <T> void put(String key, T value) {
        RBucket<T> bucket = redisson.getBucket(RedisConstant.REDIS_KEY_PREFIX + key);
        bucket.set(value, Duration.ofSeconds(DEFAULT_EXPIRED));
    }

    /**
     * 以string的方式设置缓存
     *
     * @param key
     * @param value
     */
    public void putString(String key, String value) {
        RBucket<String> bucket = redisson.getBucket(RedisConstant.REDIS_KEY_PREFIX + key, StringCodec.INSTANCE);
        bucket.set(value, Duration.ofSeconds(DEFAULT_EXPIRED));
    }

    /**
     * 以string的方式保存缓存（与其他应用共用redis时需要使用该函数）
     *
     * @param key     缓存key
     * @param value   缓存值
     * @param expired 缓存过期时间
     */
    public void putString(String key, String value, long expired) {
        RBucket<String> bucket = redisson.getBucket(RedisConstant.REDIS_KEY_PREFIX + key, StringCodec.INSTANCE);
        bucket.set(value, expired <= 0 ? Duration.ofSeconds(DEFAULT_EXPIRED) : Duration.ofSeconds(expired));
    }


    /**
     * 设置缓存
     *
     * @param key     缓存key
     * @param value   缓存值
     * @param expired 缓存过期时间
     * @param <T>     类型
     */
    public <T> void put(String key, T value, long expired) {
        RBucket<T> bucket = redisson.getBucket(RedisConstant.REDIS_KEY_PREFIX + key);
        bucket.set(value, expired <= 0 ? Duration.ofSeconds(DEFAULT_EXPIRED) : Duration.ofSeconds(expired));
    }

    /**
     * 移除缓存
     *
     * @param key
     */
    public void remove(String key) {
        redisson.getBucket(RedisConstant.REDIS_KEY_PREFIX + key).delete();
    }

    /**
     * 批量移除缓存
     * @param keys
     */
    public void removeBatch(Collection<String> keys) {
        if (CollectionUtils.isEmpty(keys)) {
            return;
        }
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 判断缓存是否存在
     *
     * @param key
     * @return
     */
    public boolean exists(String key) {
        return redisson.getBucket(RedisConstant.REDIS_KEY_PREFIX + key).isExists();
    }


    /**
     * 暴露redisson的RList对象
     *
     * @param key
     * @param <T>
     * @return
     */
    public <T> RList<T> getRedisList(String key) {
        return redisson.getList(RedisConstant.REDIS_KEY_PREFIX + key);
    }

    /**
     * 暴露redisson的RMapCache对象
     *
     * @param key
     * @param <K>
     * @param <V>
     * @return
     */
    public <K, V> RMapCache<K, V> getRedisMap(String key) {
        return redisson.getMapCache(RedisConstant.REDIS_KEY_PREFIX + key);
    }

    /**
     * 暴露redisson的RSET对象
     *
     * @param key
     * @param <T>
     * @return
     */
    public <T> RSet<T> getRedisSet(String key) {
        return redisson.getSet(RedisConstant.REDIS_KEY_PREFIX + key);
    }


    /**
     * 暴露redisson的RScoredSortedSet对象
     *
     * @param key
     * @param <T>
     * @return
     */
    public <T> RScoredSortedSet<T> getRedisScoredSortedSet(String key) {
        return redisson.getScoredSortedSet(RedisConstant.REDIS_KEY_PREFIX + key);
    }

    /**
     * 暴露redisson的Lock对象
     *
     * @param key
     * @return
     */
    public RLock getRedisLock(String key) {
        return redisson.getLock(RedisConstant.REDIS_KEY_PREFIX + key);
    }

    /**
     * 自增
     * @param key
     * @return
     */
    public Long increment(String key) {
        RAtomicLong atomicLong = redisson.getAtomicLong(key);
        return atomicLong.incrementAndGet();
    }

    /**
     * 自减
     * @param key
     * @return
     */
    public Long decrement(String key) {
        RAtomicLong atomicLong = redisson.getAtomicLong(key);
        return atomicLong.decrementAndGet();
    }

}