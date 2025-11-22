package com.xiacong.common.filter;


import com.xiacong.common.constant.CommonConstant;
import com.xiacong.common.util.TraceIdUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;

import java.io.IOException;


/**
 * 过滤器方式记录traceId
 * 优点：traceId覆盖全面
 * 缺点：需要处理http请求对象进行复制
 */
@Slf4j
@WebFilter(filterName = "traceIdFilter", urlPatterns = "/*", asyncSupported = true)
@Order(0)
public class TraceIdFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletRequest requestWrapper = new RequestWrapper(request);
        String header = request.getHeader(CommonConstant.TRACE_ID);
        if (StringUtils.isNotEmpty(header)) {
            MDC.put(CommonConstant.TRACE_ID, header);
        } else {
            MDC.put(CommonConstant.TRACE_ID, TraceIdUtil.createTraceId(null));
        }
        log.debug("请求接口:{}", request.getRequestURI());
        chain.doFilter(requestWrapper, response);
    }

    @Override
    public void destroy() {
        TraceIdUtil.removeTraceId();
    }
}
