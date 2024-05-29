package com.xiacong.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author xiacong
 * @Classname LoginDTO
 * @Version 1.0.0
 * @Date 2024/5/10 9:48
 * @Created by xiacong
 */
@Data
public class LoginDTO {

    @NotNull
    private String usrName;
    @NotNull
    private String passwd;
}
