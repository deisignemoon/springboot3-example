package com.xiacong.common.util;

import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigDecimal;

/**
 *
 *
 * @author xiacong
 * @Classname MerchantInfoDTO
 * @Version 1.0.0
 * @Date 2025/10/9 16:40
 * @Created by xiacong
 */
@Data
public class MerchantInfoExcel {

    @Column(name = "商户ID")
    private String merchantId;
    @Column(name = "商户名称")
    private String merchantName;
    @Column(name = "企业名称")
    private String companyName;
    @Column(name = "商户类型")
    private String merchantType;
    @Column(name = "商户状态")
    private Integer merchantStatus;
    @Column(name = "统一社会信用代码")
    private String creditCode;
    @Column(name = "交易金额")
    private BigDecimal payAmt = BigDecimal.ZERO;
    @Column(name = "退款金额")
    private BigDecimal refundAmt = BigDecimal.ZERO;
    @Column(name = "订单数量")
    private Integer orderCount = 0;
}
