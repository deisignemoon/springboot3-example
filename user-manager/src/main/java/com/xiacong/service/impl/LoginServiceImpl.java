package com.xiacong.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.xiacong.model.dto.LoginDTO;
import com.xiacong.service.LoginService;
import com.xiacong.util.JwtUtil;
import com.xiacong.util.UserInfoRedisUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiacong
 * @Classname LoginServiceImpl
 * @Version 1.0.0
 * @Date 2024/5/16 17:23
 * @Created by xiacong
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {
    @Resource
    private AuthenticationProvider authenticationProvider;

    @Resource
    private JwtUtil jwtUtil;
    @Resource
    private UserInfoRedisUtil userInfoRedisUtil;

    @Override
    public Map<String, Object> login(LoginDTO dto) {
        String usrName = dto.getUsrName();
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(usrName, dto.getPasswd());
        Authentication authenticate = null;
        userInfoRedisUtil.loginFailCountCheck(usrName);
        try {
            authenticate = authenticationProvider.authenticate(auth);
        } catch (BadCredentialsException e) {
            userInfoRedisUtil.saveLoginErrorInfo(usrName, e);
            throw e;
        }
        //清除可能存在的登录信息
        userInfoRedisUtil.clearUserInfo(usrName);
        Map<String, Object> map = new HashMap<>();
        String token = jwtUtil.generateToken((String) authenticate.getCredentials());
        //redis放置用户信息
        userInfoRedisUtil.saveUserLoginInfo(usrName, token, JSONObject.toJSONString(authenticate));
        map.put("token", token);
        return map;
    }

}
