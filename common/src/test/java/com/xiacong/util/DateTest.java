package com.xiacong.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Snowflake;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RedissonClient;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public void test012() {
        Date date1 = new Date(1711900800000L);
        Date date2 = new Date(1743350400000L);
        System.out.println(date1);
        System.out.println(date2);
        long l = DateUtil.betweenMonth(date1, DateUtil.offsetDay(date2, 1), true);
        System.out.println(l);
    }

    @Test
    public void test01() {
        Long month = 25L;
        BigDecimal year = new BigDecimal(month).divide(new BigDecimal("12"), 0, RoundingMode.UP);
        System.out.println(year);
    }

    //@Resource
    private RedissonClient redissonClient;

    @Test
    void contextLoads() {
        redissonClient.getBucket("hello").set("{\"aa\":\"bb\"}");
        String test = (String) redissonClient.getBucket("hello").get();
        System.out.println(test);
        RAtomicLong seqCount = redissonClient.getAtomicLong("SeqCount");
    }

    @Test
    public void test02() {
        LocalDate localDate = Instant.ofEpochMilli((100L) + Snowflake.DEFAULT_TWEPOCH).atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println(localDate);
    }

    @Data
    class TestObj {
        private String name;
        private LocalDateTime date;

        public TestObj(String name, LocalDateTime date) {
            this.name = name;
            this.date = date;
        }
    }

    @Test
    public void test03() {
        LocalDateTime now = LocalDateTime.now();
        List<TestObj> list = new ArrayList<>();
        list.add(new TestObj("a1",now.plusMinutes(30L)));
        list.add(new TestObj("a2",now.plusMinutes(31L)));
        list.add(new TestObj("a3",now.plusMinutes(45L)));
        list.add(new TestObj("a4",now.plusMinutes(66L)));
        Map<LocalDateTime, List<TestObj>> collect = list.stream().collect(Collectors.groupingBy(data -> data.getDate().truncatedTo(ChronoUnit.HOURS)));
        System.out.println(collect);
        Date date = new Date();
        ZonedDateTime time1 = ZonedDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        ZonedDateTime time2 = ZonedDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        System.out.println(time1);
        System.out.println(time2);
        System.out.println(time1.equals(time2));
        System.out.println(time1.hashCode());
        System.out.println(time2.hashCode());
    }

    private ZonedDateTime convertDateToTime(Date date) {
        return ZonedDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
    }
}
