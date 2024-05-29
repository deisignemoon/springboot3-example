package com.xiacong.common.util;

import cn.hutool.core.lang.Snowflake;

/**
 * @author yue
 * @date 2023/7/26 10:32
 */

public class SequenceUtil {

    private static Snowflake snowflake = new Snowflake(0, 0);

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
        return snowflake.nextId();
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
        return String.valueOf(snowflake.nextId());
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
        long id = snowflake.nextId();
        return per + id;
    }
}
