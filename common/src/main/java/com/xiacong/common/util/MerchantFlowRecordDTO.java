package com.xiacong.common.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商户流水记录表
 *
 * @author ly
 * @since 1.0.0 2023-12-18
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MerchantFlowRecordDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;


    private Long merchantId;


    private String orderCode;


    private Integer source;


    private BigDecimal amount;


    private Integer flowType;

    private Integer consumeType;


    private Integer payType;

    private Integer isOnlinePayment;

    private String remark;

    private Long creator;

    private Date createDate;


    private BigDecimal charge;

    private Integer num;

    private BigDecimal discountAmount;

    private BigDecimal orderAmount;

    private String merchantName;
}