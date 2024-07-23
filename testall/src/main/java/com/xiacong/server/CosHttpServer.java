package com.xiacong.server;

import com.xiacong.event.VirtualTableCacheRefershFinishEvent;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;

/**
 * @author xiacong
 * @Classname CosHttpServer
 * @Version 1.0.0
 * @Date 2024/5/30 9:41
 * @Created by xiacong
 */
@Component
public class CosHttpServer {
    @Resource
    private MyNettyFilter httpHandler;
    @Resource
    private MyHandler myHandler;

    //@EventListener
    public void createServer(VirtualTableCacheRefershFinishEvent event) {
/*        ServerBootstrap b = new ServerBootstrap();
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workerGroup = new NioEventLoopGroup(2);
        b.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline p = ch.pipeline();
                        // 添加其他处理器...
                        p.addLast(httpHandler);
                        // 添加业务处理器...
                        p.addLast(myHandler);
                    }
                });
        b.bind(8888).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("HTTP server started on port 8888");
            } else {
                System.err.println("HTTP server failed to start");
            }
        });
        return b;*/
        DisposableServer server =
                HttpServer.create().port(8888)
                        .route(routes -> routes
                                // 提供GET请求/hello并返回Hello World
                                .get("/hello", (request, response) -> response.sendString(Mono.just("Hello World!")))
                                // 为POST请求提供服务/echo并将接收到的请求正文作为响应返回
                                .post("/echo", (request, response) -> response.send(request.receive().retain()))
                                // 提供GET请求/path/{param}并返回路径参数的值
                                .get("/path/{param}", (request, response) -> response.sendString(Mono.just(request.param("param"))))
                                // 为websocket提供服务/ws，并将接收到的传入数据作为传出数据返回
                                .ws("/ws", (wsInbound, wsOutbound) -> wsOutbound.send(wsInbound.receive().retain())))
                        .bindNow();

        server.onDispose();
        //return server;
    }
}
