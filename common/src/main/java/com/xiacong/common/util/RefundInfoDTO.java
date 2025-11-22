package com.xiacong.common.util;

import lombok.Data;

import java.math.BigDecimal;

/**
 *
 *
 * @author xiacong
 * @Classname RefundInfoDTO
 * @Version 1.0.0
 * @Date 2025/9/15 15:25
 * @Created by xiacong
 */
@Data
public class RefundInfoDTO {

    private String orderCode;

    private Integer orderType;

    private BigDecimal amount = BigDecimal.ZERO;

    private BigDecimal refundAmount = BigDecimal.ZERO;

    private String refundIds = "";
}
