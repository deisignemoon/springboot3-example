package com.xiacong.common.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 退款信息表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 3.0 2023-10-23
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IsRefundInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String orderCode;
    private BigDecimal amount;
    private Integer refundType;
    private Integer refundStatus;
    private String refundReason;
    private Date refundDate;
    private String approveStatus;
    private String approveResult;
    private Long approver;
    private Date approveDate;
    private Long creator;
    private Date createDate;
    private Long updater;
    private Date updateDate;
    private Integer status;
    private String remark;
    private Integer delFlag;
    private Boolean tip = false;
    private String details;

    //1需要退款 0无需退款
    private Integer isRefund;
}
