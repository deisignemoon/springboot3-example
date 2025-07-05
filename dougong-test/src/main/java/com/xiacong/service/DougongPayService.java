package com.xiacong.service;

import java.util.Map;

/**
 *
 *
 * @author xiacong
 * @Classname DougongPayService
 * @Version 1.0.0
 * @Date 2025/4/27 13:37
 * @Created by xiacong
 */
public interface DougongPayService {
    Map<String, Object> orderCreate(String orderCode, String openId, String tradeType);

}
