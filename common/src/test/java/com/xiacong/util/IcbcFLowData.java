package com.xiacong.util;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 *
 * @author xiacong
 * @Classname IcbcFLowData
 * @Version 1.0.0
 * @Date 2025/11/12 13:06
 * @Created by xiacong
 */
@Data
public class IcbcFLowData {

    private Date paymentTime;

    private Date orderDate;

    private String payType;

    private BigDecimal payAmount;

    private BigDecimal orderAmount;

    private String orderCode;
}
