
package com.xiacong.common.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.xiacong.common.result.ResultVO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

import java.nio.file.AccessDeniedException;
import java.util.Set;

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
     * 幂等异常处理
     * @param ex
     * @return
     */
    @ExceptionHandler(DuplicateKeyException.class)
    public ResultVO<Object> exceptionHandler(DuplicateKeyException ex) {
        log.error(ex.getMessage());
        String[] split = ex.getMessage().split(" ");
        for (int i = 0; i < split.length; i++) {
            if (StringUtils.equals("entry", split[i])) {
                String msg = split[i + 1] + "已存在";
                return ResultVO.failed(msg);//将msg传到error里面，以便于报错后提示给客户端
            }
        }
        return ResultVO.failed(SystemCodeInfo.SYSTEM_ERROR.getCode(), "数据库操作失败,请联系管理员");
    }

    /**
     * 未能捕获的异常
     */
    @ExceptionHandler(Exception.class)
    public ResultVO<Object> handleException(Exception e) {
        log.error("系统异常", e);
        return ResultVO.failed(SystemCodeInfo.SYSTEM_ERROR.getCode(), e.getMessage());
    }

    @ExceptionHandler(ServiceException.class)
    public ResultVO<Object> handleServiceException(ServiceException e) {
        log.warn("自定义异常:{}", e.getMessage());
        return ResultVO.failed(String.valueOf(e.getCode()), e.getMsg());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResultVO<Object> handleError(MissingServletRequestParameterException e) {
        log.warn("缺少请求参数:{}", e.getMessage());
        return ResultVO.failed(SystemCodeInfo.PARAM_MISS.getCode(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResultVO<Object> handleError(MethodArgumentTypeMismatchException e) {
        log.warn("请求参数格式错误:{}", e.getMessage());
        return ResultVO.failed(SystemCodeInfo.PARAM_TYPE_ERROR.getCode(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO<Object> handleError(MethodArgumentNotValidException e) {
        log.warn("参数验证失败:{}", e.getMessage());
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return ResultVO.failed(SystemCodeInfo.PARAM_BIND_ERROR.getCode(), objectError.getDefaultMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResultVO<Object> handleError(HttpMessageNotReadableException e) {
        log.error("消息不能读取:{}", e.getMessage());
        String errorInfo = "";
        try {
            String fieldName = ((MismatchedInputException) e.getCause()).getPath().get(0).getFieldName();
            errorInfo = fieldName + SystemCodeInfo.MSG_NOT_READABLE.getCnMsg();
            if (null != e.getRootCause()) {
                errorInfo = UserTipGenerator.getUserMessage2((InvalidFormatException) e.getRootCause());
            }
        } catch (Exception ex) {
            log.error("消息无法读取异常处理，获取字段名失败");
        }
        return ResultVO.failed(SystemCodeInfo.MSG_NOT_READABLE.getCode(), errorInfo);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResultVO<Object> handleError(HttpRequestMethodNotSupportedException e) {
        log.error("不支持当前请求方法:{}", e.getMessage());
        return ResultVO.failed(SystemCodeInfo.METHOD_NOT_SUPPORTED.getCode(), SystemCodeInfo.METHOD_NOT_SUPPORTED.getEnMsg());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResultVO<Object> handleError(AccessDeniedException e) {
        log.error("不支持当前请求方法:{}", e.getMessage());
        return ResultVO.failed(SystemCodeInfo.FUNCTION_NO_PERMISSION.getCode(), SystemCodeInfo.FUNCTION_NO_PERMISSION.getCnMsg());
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResultVO<Object> handleError(HttpMediaTypeNotSupportedException e) {
        log.error("不支持当前媒体类型:{}", e.getMessage());
        return ResultVO.failed(SystemCodeInfo.MEDIA_TYPE_NOT_SUPPORTED.getCode(), SystemCodeInfo.MEDIA_TYPE_NOT_SUPPORTED.getEnMsg());
    }

    @ExceptionHandler({BindException.class})
    public ResultVO<Object> MethodArgumentNotValidExceptionHandler(BindException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return ResultVO.failed(SystemCodeInfo.PARAM_BIND_ERROR.getCode(), objectError.getDefaultMessage());
    }

}
