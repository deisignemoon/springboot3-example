package com.xiacong.common.exception.rpc;


import com.xiacong.common.exception.ServiceException;
import com.xiacong.common.exception.SystemCodeInfo;
import com.xiacong.common.result.RpcResultVO;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 名称：处理异常返回结果
 * 描述：
 *
 * @author Wilson
 * @version 1.0.0
 * @date 2021/7/7 15:00
 */
@Slf4j
public class RpcRestExceptionHandler implements MethodInterceptor {

    @Override
    public Object invoke(final MethodInvocation methodInvocation) throws Throwable {
        try {
            return methodInvocation.proceed();
        } catch (ServiceException e) {
            log.error("ServiceException", e);
            return exceptionProcessor(methodInvocation, e);
        } catch (Exception e) {
            log.error("Exception:", e);
            return exceptionProcessor(methodInvocation, e);
        }
    }

    private Object exceptionProcessor(MethodInvocation methodInvocation, Exception e) {
        Object[] args = methodInvocation.getArguments();
        Method method = methodInvocation.getMethod();
        String methodName = method.getDeclaringClass().getName() + "." + method.getName();
        log.error("RPC服务[method=" + methodName + "] params=" + Arrays.toString(args) + "异常：", e);
        Class<?> clazz = method.getReturnType();
        if (clazz.equals(RpcResultVO.class)) {
            RpcResultVO result = new RpcResultVO();
            if (e instanceof ServiceException) {
                result.setCode(((ServiceException) e).getCode());
                result.setMsg(e.getMessage());
            } else {
                result.setCode(SystemCodeInfo.SYSTEM_ERROR.getCode());
                result.setMsg(e.getMessage());
            }
            return result;
        }
        return null;
    }
}
