package com.xiacong.model.dto;

import com.xiacong.common.constant.CommonValidConstant;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

/**
 * @author xiacong
 * @Classname TestDTO
 * @Version 1.0.0
 * @Date 2024/6/14 11:28
 * @Created by xiacong
 */
@Data
public class TestDTO {

    @Pattern(regexp = CommonValidConstant.multPhoneNoRegexp, message = "手机号" + CommonValidConstant.formatErrorMsg)
    private String phoneNo;
}
