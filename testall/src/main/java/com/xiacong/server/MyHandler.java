package com.xiacong.server;

import com.xiacong.flow.FlowEngine;
import com.xiacong.flow.common.content.ApplicationContent;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author xiacong
 * @Classname MyHandler
 * @Version 1.0.0
 * @Date 2024/5/30 11:02
 * @Created by xiacong
 */
@Component
public class MyHandler extends ChannelInboundHandlerAdapter {
    @Resource
    private FlowEngine flowEngine;
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ApplicationContent content = new ApplicationContent();
        //todo 筛选正确流程
        content.setFlowId("634348458463645863");
        flowEngine.startFlow(content);
        ctx.fireChannelRead(content);
    }
}
