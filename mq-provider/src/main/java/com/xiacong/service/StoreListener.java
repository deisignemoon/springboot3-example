package com.xiacong.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 接收消息
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class StoreListener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "store.addFavorite.success.queue", durable = "true"), // 队列 起名规则（服务名+业务名+成功+队列），durable持久化
            exchange = @Exchange(name = "addFavorite.direct"), // 交换机名称，交换机默认类型就行direct，所以不用配置direct
            key = "addFavorite.success" // 绑定的key
    ))
    public void listenAddFavoriteCountsSuccess(Long storeId){
        log.info("storeId:{} 收到消息，时间{}", storeId,new Date());
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "delay.queue", durable = "true"),
            exchange = @Exchange(value = "delay.direct",delayed = "true"), //delayed  这是延迟交换机开启
            key = "delay"
    ))
    public void listenDelayMessage(String msg){
        log.info("storeId:{} 收到消息，时间{}", msg,new Date());
        log.info("接收到delay.queue的延迟消息：{}",msg);
    }
}
