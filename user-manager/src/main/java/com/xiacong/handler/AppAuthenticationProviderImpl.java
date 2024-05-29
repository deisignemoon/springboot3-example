package com.xiacong.handler;

import com.xiacong.service.impl.UserDetailsServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 自定义登录处理器
 *
 * @author xiacong
 * @Classname AppAuthenticationProviderImpl
 * @Version 1.0.0
 * @Date 2024/5/16 16:44
 * @Created by xiacong
 */
@Component
public class AppAuthenticationProviderImpl implements AuthenticationProvider {
    @Resource
    private UserDetailsServiceImpl userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取表单用户名
        String username = (String) authentication.getPrincipal();
        // 获取表单用户填写的密码
        String password = (String) authentication.getCredentials();
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        String detailsPassword = userDetails.getPassword();
        if (!Objects.equals(password, detailsPassword)) {
            throw new BadCredentialsException("用户名或密码不正确");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, username, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
