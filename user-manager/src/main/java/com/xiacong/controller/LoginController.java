package com.xiacong.controller;

import com.xiacong.common.result.ResultVO;
import com.xiacong.model.dto.LoginDTO;
import com.xiacong.service.LoginService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author xiacong
 * @Classname UserController
 * @Version 1.0.0
 * @Date 2024/5/10 9:40
 * @Created by xiacong
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Resource
    private LoginService loginService;

    @PostMapping("/login")
    public ResultVO<Map<String, Object>> login(@RequestBody LoginDTO dto) {
        Map<String, Object> login = loginService.login(dto);
        return ResultVO.ok(login);
    }

}
