package com.xiacong.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 *
 *
 * @author xiacong
 * @Classname WxDataDTO
 * @Version 1.0.0
 * @Date 2025/4/27 13:32
 * @Created by xiacong
 */
@Data
public class WxDataDTO implements Serializable {

    /**
     * 子商户应用ID
     * 子商户在微信申请的应用ID，全局唯一。走聚合正扫发货管理的商户，使用的微信公众号/小程序支付 需要填写sub_appid+sub_openid
     */
    private String sub_appid;

    /**
     * 子商户用户标识
     * 公众号和小程序场景必填。用户在子商户sub_appid下的唯一标识。下单前需获取到用户的sub_openid，sub_openid获取详见微信文档openid获取。
     */
    private String sub_openid;
}
