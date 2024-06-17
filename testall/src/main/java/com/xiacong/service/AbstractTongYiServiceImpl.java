package com.xiacong.service;

import java.util.Map;

/**
 * @author xiacong
 * @Classname AbstractTongYiServiceImpl
 * @Version 1.0.0
 * @Date 2024/6/17 15:16
 * @Created by xiacong
 */
public interface AbstractTongYiServiceImpl {

    String completion(String message);

    Map<String, String> streamCompletion(String message);
}
