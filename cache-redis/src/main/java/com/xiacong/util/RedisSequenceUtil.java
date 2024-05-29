package com.xiacong.util;

import cn.hutool.core.lang.Snowflake;
import com.xiacong.common.constant.CommonConstant;
import com.xiacong.common.constant.RedisConstant;
import com.xiacong.repository.RedisRepostory;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author yue
 * @date 2023/7/26 10:32
 */
@Component
public class RedisSequenceUtil {


    private static RedisRepostory redisRepostory;

    private static Snowflake snowflake = null;

    private static Long workId;

    private static Long dataCenterId;

    private RedisSequenceUtil() {
    }

    @Resource
    public void setRedisRepostory(RedisRepostory redisRepostory) {
        RedisSequenceUtil.redisRepostory = redisRepostory;
    }


    public static Snowflake getSnowflake() {
        if (snowflake == null) {
            synchronized (RedisSequenceUtil.class) {
                if (snowflake == null) {
                    Long count = redisRepostory.increment(RedisConstant.SEQ_SNOW_FLAKE_COUNT_KEY);
                    workId = count & 31;
                    dataCenterId = count >> 5 & 31;
                    snowflake = new Snowflake(workId, dataCenterId);
                }
            }
        }
        return snowflake;
    }

    /**
     * <p >
     * 功能：获取一个long数字的唯一序列号
     * </p>
     *
     * @param
     * @return
     * @author wangpeng
     * @date 2018/1/30 9:14
     */
    public static Long getUuId() {
        return getSnowflake().nextId();
    }

    /**
     * 功能：获取一个19位数字的唯一序列号
     *
     * @param
     * @return
     * @author huanghongjing
     * @date 2018/1/30 9:14
     */
    public static String getUuIdStr() {
        return String.valueOf(getSnowflake().nextId());
    }

    public static String getDateUuIdStr() {
        long id = getSnowflake().nextId();
        LocalDateTime localDateTime = Instant.ofEpochMilli((id >> 22) + Snowflake.DEFAULT_TWEPOCH).atZone(ZoneId.systemDefault()).toLocalDateTime();
        return localDateTime.format(DateTimeFormatter.ofPattern(CommonConstant.DATE_TIME_FORMATE4)) + id;
    }

    public static String parser(Long id) {
        LocalDateTime localDateTime = Instant.ofEpochMilli((id >> 22) + Snowflake.DEFAULT_TWEPOCH).atZone(ZoneId.systemDefault()).toLocalDateTime();
        long workId = id >> 12 & 31;
        long dataCenterId = id >> 17 & 31;
        return localDateTime.format(DateTimeFormatter.ofPattern(CommonConstant.DATE_TIME_FORMATE4)) + CommonConstant.AEPARATOR2 + dataCenterId + CommonConstant.AEPARATOR2 + workId;
    }

    /**
     * 功能：获取一个存在前置字符串的19位数字的唯一序列号
     *
     * @param
     * @return
     * @author huanghongjing
     * @date 2018/1/30 9:14
     */
    public static String getUuIdStr(String per) {
        long id = getSnowflake().nextId();
        return per + id;
    }
}
