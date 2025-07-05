package com.xiacong.util.suqi;

import lombok.Data;

import java.io.Serializable;

/**
 *
 *
 * @author xiacong
 * @Classname TravelPerson
 * @Version 1.0.0
 * @Date 2025/6/4 9:09
 * @Created by xiacong
 */
@Data
public class TravelPerson implements Serializable {

    private static final long serialVersionUID = 1L;

    public TravelPerson() {
    }

    public TravelPerson(String personName, String contactTel, String cardType, String cardNumber) {
        this.personName = personName;
        this.contactTel = contactTel;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
    }

    /**
     * 姓名
     */
    private String personName;

    /**
     * 联系方式
     */
    private String contactTel;

    /**
     * 证件类型
     */
    private String cardType;

    /**
     * 证件号码1， 身份证 2,护照 3，港澳通行证 4， 台胞 证 5 ， 军 官 证6， 回乡证
     */
    private String cardNumber;
}
