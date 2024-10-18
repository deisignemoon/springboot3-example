
package com.xiacong.exception;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.xiacong.common.exception.SystemCodeInfo;
import com.xiacong.common.result.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理，处理可预见的异常，Order 排序优先级高
 *
 * <p>
 * Bean-Violation 异常处理
 * </p>
 *
 * @author L.cm
 */
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
@RestControllerAdvice
public class RestExceptionHandler {

    /**
     * jwt异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(TokenExpiredException.class)
    public ResultVO<Object> jwtException(TokenExpiredException e) {
        return ResultVO.failed(SystemCodeInfo.SYSTEM_ERROR.getCode(), e.getMessage());
    }

}
