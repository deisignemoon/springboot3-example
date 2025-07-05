package com.xiacong.http;

import lombok.Data;

import java.math.BigDecimal;

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
public class OrderDetail {
    private String orderId;
    private BigDecimal realFee;
    private String itemStateName;
}
