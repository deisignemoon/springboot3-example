package com.xiacong.common.filter;

import com.xiacong.common.validator.constrants.OperationLog;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 记录请求日志
 */
@Slf4j
@Order(Integer.MAX_VALUE)
@WebFilter(filterName = "requestLogFilter", urlPatterns = "/*")
public class RequestLogFilter extends OncePerRequestFilter {
    @Resource
    private RequestMappingHandlerMapping handlerMapping;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        // Wrapper 封装 Request 和 Response
        ContentCachingRequestWrapper cachingRequest = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper cachingResponse = new ContentCachingResponseWrapper(response);
        // 请求方法
        String methodName = request.getMethod();
        // URI
        String uri = request.getRequestURI();
        // 请求体
        byte[] requestContent = cachingRequest.getContentAsByteArray();
        log.info("Request => {} {} {}", methodName, uri, new String(requestContent));
        // 继续执行请求链
        chain.doFilter(cachingRequest, cachingResponse);
        // 响应状态
        int status = response.getStatus();
        // 响应体
        byte[] responseContent = cachingResponse.getContentAsByteArray();
        log.info("Response <= {} {}", status, new String(responseContent));
        cachingResponse.copyBodyToResponse();
        // 获取当前请求的处理器
        try {
            Object handler = handlerMapping.getHandler(request).getHandler();
            if (handler instanceof HandlerMethod) {
                HandlerMethod handlerMethod = (HandlerMethod) handler;
                Method method = handlerMethod.getMethod();
                if (method.getDeclaringClass().isAnnotationPresent(OperationLog.class)) {
                    OperationLog classAnnotation = method.getDeclaringClass().getAnnotation(OperationLog.class);
                    String module = classAnnotation.module();
                    String descrip = null;
                    if (method.isAnnotationPresent(OperationLog.class)) {
                        OperationLog methodAnnotation = method.getAnnotation(OperationLog.class);
                        descrip = methodAnnotation.descrip();
                    }
                    // todo 记录操作日志
                }
            }
        } catch (Exception e) {
            log.error("处理当前请求操作日志失败", e);
            throw new RuntimeException(e);
        }
    }

}