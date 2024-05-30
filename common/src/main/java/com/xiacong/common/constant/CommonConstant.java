package com.xiacong.common.constant;

/**
 * @author xiacong
 * @Classname CommonConstant
 * @Version 1.0.0
 * @Date 2023/10/19 16:48
 * @Created by xiacong
 */
public class CommonConstant {

    /**
     * 追踪号
     */
    public static final String TRACE_ID="traceId";

    /**
     * 当前用户信息
     */
    public static final String CURUSER="CURUSER";


    /**
     * 日期格式 yyyyMMdd
     */
    public static final String DATE_FORMATE = "yyyy-MM-dd";

    /**
     * 日期格式 yyyy-MM-dd AM/PM
     */
    public static final String DATE_FORMATE2 = "yyyy-MM-dd a";

    /**
     * 时间格式1
     */
    public static final String DATE_TIME_FORMATE = "yyyy/MM/dd HH/mm/ss";

    /**
     * 时间格式2
     */
    public static final String DATE_TIME_FORMATE2 = "yyyy-MM-dd HH:mm:ss";

    /**
     * 时间格式3 精确到分钟
     */
    public static final String DATE_TIME_FORMATE3 = "yyyy-MM-dd HH:mm";

    /**
     * 时间格式4
     */
    public static final String DATE_TIME_FORMATE4 = "yyyyMMddHHmmss";

    /**
     * 时区
     */
    public static final String TIME_ZONE = "GMT+8";
    /**
     * 井号
     */
    public static final String HASHTAG = "#";

    /**
     * 与符号
     */
    public static final String AND = "&";

    /**
     * 等于符号
     */
    public static final String EQUAL = "=";

    public static final String AEPARATOR1 = "-";

    public static final String AEPARATOR2 = ",";

    public static final String STAR = "*";

    public static final String SUCCESS = "00000000";
    public static final String FAIL = "99999999";

    public static final String DELETE_STS = "1";
    public static final String NO_DELETE_STS = "0";

    /**
     * 雪花算法机器id计数器key
     */
    public static final String SEQ_SNOW_FLAKE_COUNT_KEY = "SEQ_SNOW_FLAKE_COUNT_KEY";
    public static final String REDIS_KEY_PREFIX = "";
    public static final Long TOKEN_EXPIRE_TIME = 7*24*3600L;
    public static final Long LOGIN_FAIL_EXPIRE_TIME = 5*60L;
}
