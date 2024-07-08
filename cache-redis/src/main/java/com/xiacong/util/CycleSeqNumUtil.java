package com.xiacong.util;

import com.xiacong.common.constant.CommonConstant;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CycleSeqNumUtil {
    @Resource
    private RedissonUtil redisUtils;

    private static final String CYCLE_SEQ_NUM_KEY = "CYCLE_SEQ_NUM_KEY";

    public String getCycleSeqNum() {
        Long increment = redisUtils.increment(CYCLE_SEQ_NUM_KEY);
        return LocalDate.now().format(DateTimeFormatter.ofPattern(CommonConstant.DATE_FORMATE3)) + StringUtils.leftPad(String.valueOf(increment), 4, "0");
    }

    @Scheduled(cron = "0 * * * * ?")
    @Async("controlAsync")
    public void init() {
        redisUtils.remove(CYCLE_SEQ_NUM_KEY);
    }
}