package com.xiacong.common.util;

import cn.hutool.core.date.DateUtil;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 *
 *
 * @author xiacong
 * @Classname TImeUtils
 * @Version 1.0.0
 * @Date 2024/9/10 15:29
 * @Created by xiacong
 */
public class TimeUtils {

    //单例模式
    private TimeUtils() {
    }

    public static long[] calculateTimeArray(LocalDateTime startTime, LocalDateTime endTime) {
        long[] res = new long[5];
        long years = ChronoUnit.YEARS.between(startTime, endTime);
        res[0] = years;
        long months = ChronoUnit.MONTHS.between(startTime.plusYears(years), endTime);
        res[1] = months;
        long days =  ChronoUnit.DAYS.between(startTime.plusYears(years).plusMonths(months), endTime);
        res[2] = days;
        long hours = ChronoUnit.HOURS.between(startTime.plusYears(years).plusMonths(months).plusDays(days), endTime);
        res[3] = hours;
        long minutes = ChronoUnit.MINUTES.between(startTime.plusYears(years).plusMonths(months).plusDays(days).plusHours(hours), endTime) % 60;
        res[4] = minutes;
        return res;
    }

    public static String assembleTimeDifferenceString(long[] timeArray) {
        String res = "";
        if (timeArray[0] > 0 || StringUtils.isNoneBlank(res)) {
            res+=timeArray[0]+"年";
        }
        if (timeArray[1] > 0 || StringUtils.isNoneBlank(res)) {
            res+=timeArray[1]+"月";
        }
        if (timeArray[2] > 0 || StringUtils.isNoneBlank(res)) {
            res+=timeArray[2]+"天";
        }
        if (timeArray[3] > 0 || StringUtils.isNoneBlank(res)) {
            res+=timeArray[3]+"小时";
        }
        if (timeArray[4] > 0 || StringUtils.isNoneBlank(res)) {
            res+=timeArray[4]+"分钟";
        }
        return res;
    }

    /**
     * 计算两个时间之间的年、月、日、时、分的长度，并返回格式化的字符串。
     *
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 格式化的字符串，例如 "1年2月5天2小时15分钟"
     */
    public static String calculateTimeDifference(LocalDateTime startTime, LocalDateTime endTime) {
        long[] longs = calculateTimeArray(startTime, endTime);
        return assembleTimeDifferenceString(longs);
    }

    public static String calculateTimeDifference(Date startTime, Date endTime) {
        //将Date转为LocalDateTime
        LocalDateTime startDateTime = startTime.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime endDateTime = endTime.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDateTime();
        return calculateTimeDifference(startDateTime, endDateTime);
    }
}
