package com.xiacong.server;

import com.xiacong.flow.FlowEngine;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author xiacong
 * @Classname HttpHandlerImpl
 * @Version 1.0.0
 * @Date 2024/5/30 9:47
 * @Created by xiacong
 */
@Component
public class MyNettyFilter extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof FullHttpRequest) {
            FullHttpRequest request = (FullHttpRequest) msg;
            // 执行过滤逻辑，比如检查请求头或路径
            if (shouldFilter(request)) {
                // 拦截请求，例如返回403 Forbidden
                FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.FORBIDDEN);
                ctx.writeAndFlush(response);
                return;
            }
        }
        // 如果过滤通过，继续处理请求
        ctx.fireChannelRead(msg);
    }

    private boolean shouldFilter(FullHttpRequest request) {
        // 实现你的过滤规则
        return false; // 返回true表示应过滤请求
    }
}
