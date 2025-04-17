package com.xiacong.filter;


import com.xiacong.common.filter.RequestWrapper;
import com.xiacong.common.util.TraceIdUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import java.io.IOException;


@Slf4j
@WebFilter(filterName = "tokenFilter", urlPatterns = "/*")
@Order(0)
public class TokenFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.debug("tokenFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletRequest requestWrapper = new RequestWrapper(request);

        chain.doFilter(requestWrapper, response);
    }

    @Override
    public void destroy() {
        TraceIdUtil.removeTraceId();
    }
}
