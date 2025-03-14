package com.xiacong.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class SendMsg {
    @Resource
    private RabbitTemplate rabbitTemplate;

    public void add(Long storeId) {

        // 发送消息 (交换机+绑定的key和发送的消息)
        try {
            log.info("发送添加收藏消息，时间{}",new Date());
            rabbitTemplate.convertAndSend("addFavorite.direct","addFavorite.success",storeId);
        } catch (Exception e) {
            log.error("发送添加收藏消息失败，店铺id：{}",e.getMessage());
        }

    }

    public void testSendDelayMessage(){
        log.info("发送添加收藏消息，时间{}",new Date());
        rabbitTemplate.convertAndSend("delay.direct", "delay", "hello", new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setDelayLong(3000L);
                return message;
            }
        });
        log.info("消息发送成功！");
    }


}
