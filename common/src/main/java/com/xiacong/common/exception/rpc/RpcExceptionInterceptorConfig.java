package com.xiacong.common.exception.rpc;

import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 名称：异常拦截配置
 * 描述：
 *
 * @author Wilson
 * @version 1.0.0
 * @date 2021/7/7 17:58
 */
@Configuration
public class RpcExceptionInterceptorConfig {

    /**
     * Provider包
     */
    private final String execution = "execution(* com.xiacong.provider..*.*(..)))";

    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor2() {
        RpcRestExceptionHandler interceptor = new RpcRestExceptionHandler();
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(execution);
        // 配置增强类advisor
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(pointcut);
        advisor.setAdvice(interceptor);
        return advisor;
    }

}
