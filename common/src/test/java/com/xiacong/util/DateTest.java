package com.xiacong.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Snowflake;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author xiacong
 * @Classname DateTest
 * @Version 1.0.0
 * @Date 2024/2/22 14:51
 * @Created by xiacong
 */
//@SpringBootTest
public class DateTest {

    @Test
    public void test012(){
        Date date1 = new Date(1711900800000L);
        Date date2 = new Date(1743350400000L);
        long l = DateUtil.betweenMonth(date1,DateUtil.offsetDay(date2,1) , true);
        System.out.println(l);
    }

    @Resource
    private RedissonClient redissonClient;

    @Test
    void contextLoads() {
        redissonClient.getBucket("hello").set("{\"aa\":\"bb\"}");
        String test = (String) redissonClient.getBucket("hello").get();
        System.out.println(test);
        RAtomicLong seqCount = redissonClient.getAtomicLong("SeqCount");
    }

    @Test
    public void test02(){
        LocalDate localDate = Instant.ofEpochMilli((100L) + Snowflake.DEFAULT_TWEPOCH).atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println(localDate);
    }
}
