package com.xiacong.common.util;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 商户信息表
 *
 * @author ly
 * @since 1.0.0 2024-01-16
 */
@Data
public class MerchantInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String companyName;

    private Integer merchantCategory;

    private String merchantCategoryName;

    private Integer companyType;

    private String companyTypeName;

    private Integer tradeArea;

    private String legalPerson;

    private String idCard;

    private String idCardFront;

    private String idCardReverse;

    private String creditCode;

    private String linkName;

    private String phone;

    private String adminName;

    private String adminPassword;

    private Long islandId;

    private String islandName;

    private String province;

    private String city;

    private String area;

    private String street;

    private String areaDetail;

    private String storeFrontPic;

    private String licensePic;

    private String otherCertificatePic;

    private String settledPdf;

    private String ambientTimPics;

    private Integer operateStatus;

    private Integer status;

    private Long creator;

    private Date createDate;

    private Long updater;

    private Date updateDate;

    private BigDecimal personPrice;

    private Integer foodType;

    private String provideService;

}