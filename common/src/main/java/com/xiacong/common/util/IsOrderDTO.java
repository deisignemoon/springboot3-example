package com.xiacong.common.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单系统表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 3.0 2023-10-08
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IsOrderDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String orderCode;
    private Long parentId;
    private Integer orderType;
    private Integer num;
    private BigDecimal orderAmount;
    private BigDecimal discountAmount;
    private Long discountCouponUserId;
    private BigDecimal discountCouponPrice;
    private BigDecimal realityPay;
    private Integer payType;
    private Date orderTime;
    private Date payTime;
    private String openId;
    private Integer status;
    private String linkJson;
    private String linkProductJson;
    private String serviceRJson;
    private String remark;
    private Integer delFlag;
    private Long creator;
    private Date createDate;
    private Long updater;
    private Date updateDate;
    private String scenicName;
    private Integer ticketType;
    private String spotAddress;
    private String playDate;
    private String openDate;
    private BigDecimal scenicAmount;
    private BigDecimal jihuAmount;

    private String distributionScene;


    /**
     * 平台消费券码
     */
    private String platTicketCode;

    /**
     * 平台消费券码补贴金额
     */
    private BigDecimal platTicketSubsidyAmount;
}
