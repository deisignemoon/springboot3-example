package com.xiacong.common;

import lombok.Data;

/**
 * @author xiacong
 * @Classname ManagerConstant
 * @Version 1.0.0
 * @Date 2024/5/27 11:07
 * @Created by xiacong
 */
@Data
public class ManagerConstant {
    public static final String USER_MANAGER_LOGIN_FIAL_COUNT_SUFFIX = "fail: traceId: ";
    public static final String USER_MANAGER_LOGIN_FIAL_INFO_SUFFIX = "fail: info: ";
    public static final String USER_MANAGER_INFO_SUFFIX = "info";
    public static final String USER_MANAGER_TOKEN_SUFFIX = "token";
    public static final String USER_MANAGER_PERFIX = "user: manager: ";
    public static final String USER_TOKEN_PERFIX = "user: token: ";
    /**
     * redis目录标记
     */
    public static final String REDIS_FLIE_SIGN = ": ";
}
