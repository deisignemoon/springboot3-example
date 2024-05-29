package com.xiacong.handler;

import cn.hutool.json.JSONUtil;
import com.xiacong.common.ManagerConstant;
import com.xiacong.common.filter.RequestWrapper;
import com.xiacong.common.result.ResultVO;
import com.xiacong.util.JwtUtil;
import com.xiacong.util.UserInfoRedisUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class JwtLogoutSuccessHandler implements LogoutSuccessHandler {
    @Resource
    private UserInfoRedisUtil userInfoRedisUtil;

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(httpServletRequest, httpServletResponse, authentication);
        }
        HttpServletRequest requestWrapper = new RequestWrapper(httpServletRequest);
        String token = requestWrapper.getHeader(JwtUtil.HEADER);
        if (StringUtils.isNotBlank(token)) {
            String userName = userInfoRedisUtil.getUserNameByToken(token);
            if (StringUtils.isNotBlank(userName)) {
                userInfoRedisUtil.clearUserInfo(userName);
            }
        }
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.setHeader(JwtUtil.HEADER, "");
        SecurityContextHolder.clearContext();
        ResultVO<String> resultDTO = ResultVO.ok("SuccessLogout");
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        outputStream.write(JSONUtil.toJsonStr(resultDTO).getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
    }
}