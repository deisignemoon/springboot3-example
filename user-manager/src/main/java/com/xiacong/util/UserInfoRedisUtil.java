package com.xiacong.util;

import cn.hutool.core.lang.Assert;
import com.xiacong.common.ManagerConstant;
import com.xiacong.common.constant.CommonConstant;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Set;

/**
 * @author xiacong
 * @Classname UserInfoRedisUtil
 * @Version 1.0.0
 * @Date 2024/5/28 9:43
 * @Created by xiacong
 */
@Component
@Slf4j
public class UserInfoRedisUtil {
    @Resource
    private RedissonUtil redissonUtil;

    public String getUserNameByToken(String token){
        return redissonUtil.getString(ManagerConstant.USER_TOKEN_PERFIX + token);
    }

    public String getUserInfoStrByUserName(String userName){
        return redissonUtil.getString(ManagerConstant.USER_MANAGER_PERFIX + userName + ManagerConstant.REDIS_FLIE_SIGN + ManagerConstant.USER_MANAGER_INFO_SUFFIX);
    }


    /**
     * 清除redis用户信息
     *
     * @param userName
     */
    public void clearUserInfo(String userName) {
        log.debug("清除用户登录信息：{}", userName);
        Set<String> userInfoKeys = redissonUtil.getKeys(ManagerConstant.USER_MANAGER_PERFIX + userName + ManagerConstant.REDIS_FLIE_SIGN + CommonConstant.STAR);
        if (!CollectionUtils.isEmpty(userInfoKeys)) {
            String token = redissonUtil.getString(ManagerConstant.USER_MANAGER_PERFIX + userName + ManagerConstant.REDIS_FLIE_SIGN + ManagerConstant.USER_MANAGER_TOKEN_SUFFIX);
            if (StringUtils.isNotBlank(token)) {
                redissonUtil.remove(ManagerConstant.USER_TOKEN_PERFIX + token);
            }
            redissonUtil.removeBatch(userInfoKeys);
        }
    }

    /**
     * 保存登录失败信息
     * @param userName
     * @param e
     */
    public void saveLoginErrorInfo(String userName, Exception e) {
        log.error("登录失败，记录登录失败信息{}", e.getMessage());
        redissonUtil.putString(ManagerConstant.USER_MANAGER_PERFIX + userName + ManagerConstant.REDIS_FLIE_SIGN + ManagerConstant.USER_MANAGER_LOGIN_FIAL_COUNT_SUFFIX + MDC.get(CommonConstant.TRACE_ID)
                , MDC.get(CommonConstant.TRACE_ID), CommonConstant.LOGIN_FAIL_EXPIRE_TIME);
        redissonUtil.putString(ManagerConstant.USER_MANAGER_PERFIX + userName + ManagerConstant.REDIS_FLIE_SIGN + ManagerConstant.USER_MANAGER_LOGIN_FIAL_INFO_SUFFIX + MDC.get(CommonConstant.TRACE_ID)
                , e.getMessage(), CommonConstant.LOGIN_FAIL_EXPIRE_TIME);
    }

    /**
     * 保存用户登录信息
     * @param usrName
     * @param token
     * @param userInfo
     */
    public void saveUserLoginInfo(String usrName, String token, String userInfo) {
        log.debug("保存用户登录信息：{}", usrName);
        //token、用户信息、登录失败信息记录redis
        //token-userName
        redissonUtil.putString(ManagerConstant.USER_TOKEN_PERFIX + token, usrName, CommonConstant.TOKEN_EXPIRE_TIME);
        //userName->token
        redissonUtil.putString(ManagerConstant.USER_MANAGER_PERFIX + usrName + ManagerConstant.REDIS_FLIE_SIGN + ManagerConstant.USER_MANAGER_TOKEN_SUFFIX
                , token, CommonConstant.TOKEN_EXPIRE_TIME);
        //userName->userInfo
        redissonUtil.putString(ManagerConstant.USER_MANAGER_PERFIX + usrName + ManagerConstant.REDIS_FLIE_SIGN + ManagerConstant.USER_MANAGER_INFO_SUFFIX
                , userInfo, CommonConstant.TOKEN_EXPIRE_TIME);
    }

    /**
     * 登录失败次数检查
     * @param userName
     */
    public void loginFailCountCheck(String userName){
        log.debug("登录失败次数检查：{}", userName);
        Set<String> keys = redissonUtil.getKeys(ManagerConstant.USER_MANAGER_PERFIX + userName + ManagerConstant.REDIS_FLIE_SIGN + ManagerConstant.USER_MANAGER_LOGIN_FIAL_COUNT_SUFFIX + CommonConstant.STAR);
        Assert.isTrue(keys.size() < 5, "登录错误次数超过限制，请等待");
    }
}
