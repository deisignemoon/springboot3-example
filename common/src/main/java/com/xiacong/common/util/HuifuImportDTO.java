package com.xiacong.common.util;

import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @TableName book
 */
@Data
public class HuifuImportDTO implements Serializable {
    /**
     *
     */
    @Column(name = "交易日期")
    private String payDate;

    @Column(name = "订单金额(元)")
    private String orderAmt;

    @Column(name = "手续费(元)")
    private String chargeAmt;

    @Column(name = "可退金额")
    private String canRefundAmt;

    @Column(name = "退款信息")
    private String refundInfo;

    @Column(name = "交易完成时间")
    private String finishTime;

    @Column(name = "商户订单号")
    private String orderCode;

    @Column(name = "付款人标识")
    private String payPeople;

    private static final long serialVersionUID = 1L;
}