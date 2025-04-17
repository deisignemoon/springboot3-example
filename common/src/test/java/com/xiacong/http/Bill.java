package com.xiacong.http;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 *
 * @author xiacong
 * @Classname Bill
 * @Version 1.0.0
 * @Date 2025/4/7 16:24
 * @Created by xiacong
 */
@Data
public class Bill {

    private Integer lineNo;

    /**
     * 订单号
     */
    private String orderId;

    /**
     *  1-支付 2-退款
     */
    private String payType;

    /**
     * 交易日期
     */
    private Date payDate;

    /**
     * 交易金额
     */
    private BigDecimal payAmt;

    /**
     * 手续费
     */
    private BigDecimal handleAme;
}
