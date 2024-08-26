package com.xiacong.service;

import java.math.BigDecimal;

/**
 *
 *
 * @author xiacong
 * @Classname IPayService
 * @Version 1.0.0
 * @Date 2024/8/26 9:25
 * @Created by xiacong
 */
public interface IPayService {

    Boolean pay(String accountSrc, String accountDest, BigDecimal amt);
}
