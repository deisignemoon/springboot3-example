package com.xiacong.service;

import com.xiacong.model.dto.LoginDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Map;

/**
 * @author xiacong
 * @Classname LoginService
 * @Version 1.0.0
 * @Date 2024/5/16 17:21
 * @Created by xiacong
 */
public interface LoginService {
    Map<String, Object> login(LoginDTO dto);
}
