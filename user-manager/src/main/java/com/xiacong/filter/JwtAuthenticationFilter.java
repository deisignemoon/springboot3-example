package com.xiacong.filter;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.xiacong.common.ManagerConstant;
import com.xiacong.common.exception.ServiceException;
import com.xiacong.common.filter.RequestWrapper;
import com.xiacong.model.aggreate.UserAggreate;
import com.xiacong.service.impl.UserDetailsServiceImpl;
import com.xiacong.util.JwtUtil;
import com.xiacong.util.RedissonUtil;
import com.xiacong.util.UserInfoRedisUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Slf4j
@Component
@Order(1)
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Resource
    private UserInfoRedisUtil userInfoRedisUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest requestWrapper = new RequestWrapper(request);
        String token = requestWrapper.getHeader(JwtUtil.HEADER);
        // 未获取到token，继续往后走，因为后面还有鉴权管理器等去判断是否拥有身份凭证，所以可以放行
        // 没有token相当于匿名访问，若有一些接口是需要权限的，则不能访问这些接口
        if (StrUtil.isBlankOrUndefined(token)) {
            chain.doFilter(requestWrapper, response);
            return;
        }
        //使用redis获取用户信息
        String userName = userInfoRedisUtil.getUserNameByToken(token);
        if (StringUtils.isBlank(userName)) {
            throw new ServiceException("token已过期");
        }
        String userJson = userInfoRedisUtil.getUserInfoStrByUserName(userName);
        if (StringUtils.isBlank(userJson)) {
            throw new ServiceException("token已过期");
        }
        log.debug("用户信息{}", userJson);
        JSONObject jsonObject = JSONObject.parseObject(userJson);
        String detail = jsonObject.getJSONObject("principal").toString();
        UserAggreate userDetails = JSONObject.parseObject(detail, UserAggreate.class);
        String name = jsonObject.getString("credentials");
        JSONArray authorities = jsonObject.getJSONArray("authorities");
        List<GrantedAuthority> javaList = authorities.toJavaList(GrantedAuthority.class);
        // 构建UsernamePasswordAuthenticationToken，这里密码为null，是因为提供了正确的token，实现自动登录
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, name, javaList);
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(requestWrapper));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        chain.doFilter(requestWrapper, response);
    }
}