package com.xiacong.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置消息转换器
 */
@Configuration
@ConditionalOnClass(RabbitTemplate.class) //有RabbitTemplate依赖才会生效，否则不生效
public class MqConfig {
    @Bean
    public MessageConverter messageConverter(){
        //使用json序列化发送消息
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public DirectExchange delayExchange(){
        return ExchangeBuilder
                .directExchange("delay.direct")
                .delayed()  //设置delay的属性为true
                .durable(true)
                .build();
    }
}
