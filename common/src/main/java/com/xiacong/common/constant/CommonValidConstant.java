package com.xiacong.common.constant;

/**
 * 报文校验信息公共数据
 * @author xiacong
 * @Classname CommonValidConstant
 * @Version 1.0.0
 * @Date 2023/7/10 10:34
 * @Created by xiacong
 */
public class CommonValidConstant {
    public static final String notNullValidErrorMsg="不能为空";
    public static final String lengthValidErrorMsg="长度必须在{min}-{max}之间";
    public static final String moreThanValidErrorMsg="必须大于{value}";
    public static final String lessThanValidErrorMsg="必须小于{value}";
    public static final String moneyValidErrorMsg="必须大于0.00";
    public static final String formatErrorMsg="格式错误";
    public static final String moneyZero="0.00";
    public static final int moneyIntegerLength=10;
    public static final int moneyDecimalLength=2;
    public static final String phoneNoRegexp = "^([1][3,4,5,6,7,8,9][0-9]{9})?$";
    public static final String multPhoneNoRegexp = "^1[3-9]\\d{9}(\\/1[3-9]\\d{9})*$";
    public static final String cardIdRegexp = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
    public static final String letterAndNumberRegexp = "^$|^[a-zA-Z0-9]+$";
    public static final String letterRegexp = "^$|^[a-zA-Z]+$";
    public static final String letterUpRegexp = "^$|^[A-Z]+$";
}
