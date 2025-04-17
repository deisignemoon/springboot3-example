package com.xiacong.http;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 *
 * @author xiacong
 * @Classname Order
 * @Version 1.0.0
 * @Date 2025/4/7 17:00
 * @Created by xiacong
 */
@Data
public class Order {
    private String merchantId;
    private String orderCode;
    private BigDecimal amount;
    private BigDecimal orderAmount;
    private BigDecimal charge;
    private String createDate;
}
