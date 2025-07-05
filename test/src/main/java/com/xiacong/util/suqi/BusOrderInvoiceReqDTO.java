package com.xiacong.util.suqi;

import lombok.Data;

import java.io.Serializable;

/**
 *
 *
 * @author xiacong
 * @Classname BusOrderInvoiceReqDTO
 * @Version 1.0.0
 * @Date 2025/6/4 9:39
 * @Created by xiacong
 */
@Data
public class BusOrderInvoiceReqDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 苏汽订单号
     */
    private String orderNumber;

    /**
     * 购方名称
     */
    private String buyerName;

    /**
     * 购方税号
     */
    private String buyerTaxNum;

    /**
     * 购方电话
     */
    private String buyerTel;

    /**
     * 购方地址
     */
    private String buyerAddress;

    /**
     * 购方银行
     */
    private String buyerBank;

    /**
     * 购方开户行账号
     */
    private String buyerAccount;

    /**
     * 推送邮箱
     */
    private String email;

    /**
     * 金额
     */
    private String price;
}
