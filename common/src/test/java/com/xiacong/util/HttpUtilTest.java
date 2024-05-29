package com.xiacong.util;

import com.xiacong.common.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.http.client.HttpClient;
import reactor.netty.http.server.HttpServer;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiacong
 * @Classname HttpUtilTest
 * @Version 1.0.0
 * @Date 2023/10/23 9:14
 * @Created by xiacong
 */
/*@SpringBootTest*/
@Slf4j
class HttpUtilTest {

    @Test
    void makePostRequestAsync() {
        HttpUtil httpUtil = new HttpUtil();
        httpUtil.init(1000);
        Mono<String> stringMono = httpUtil.makeGetRequestAsync("https://cn.bing.com/", "?FORM=Z9FD1");
        String block = stringMono.block();
        System.out.println(block);
    }

    @Test
    void testList() {

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime day1 = now.minusHours(5);
        LocalDateTime day2 = now.minusHours(4);
        LocalDateTime day3 = now.minusHours(3);
        LocalDateTime day4 = now.minusHours(2);
        LocalDateTime day5 = now.minusHours(1);
        Node node1 = new Node(day1, day3);


    }

    @Test
    void createServer() {
        HttpServer httpServer = HttpServer.create();
        DisposableServer server = httpServer.port(8080)
                .route(routes -> routes.get("/hello", (req, resp) -> resp.sendString(Mono.just("Hello World"))))
                .bindNow();
        //1.获取业务编号
        //2.获取组装模板
        //3.获取处理流程
        //4.执行流程
        //5.获取流程执行结果
        //6.获取解析模板
        //7.返回结果
        server.onDispose().block();
    }

    class NodeList {
        List<Node> list = new LinkedList<Node>();

        public void add(Node node) {
            if (list.isEmpty()) {
                list.add(node);
                return;
            }
            Instant instant = Instant.ofEpochMilli(Long.MIN_VALUE);
            LocalDateTime time = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
            Node current = null;
            Node before = new Node(time, time);
            for (int i = 0; i <= list.size(); i++) {
                current = list.get(i);
                if ((current.start.isBefore(node.end) && node.start.isBefore(current.end)) || (before.start.isBefore(node.end) && node.start.isBefore(before.end))) {
                    throw new RuntimeException();
                }
                if (node.start.isAfter(before.end) && node.end.isBefore(current.start)) {
                    list.add(i, node);
                    before = node;
                    continue;
                } else if (current.start.isEqual(node.end)) {
                    current.start = node.start;
                } else if (before.end.isEqual(node.start)) {
                    before.end = node.end;
                }
                if (current.start.isBefore(before.end) && before.start.isBefore(current.end)) {
                    current.start = before.start;
                    list.remove(before);
                }
            }

        }
    }

    class Node {
        LocalDateTime start;
        LocalDateTime end;

        public Node(LocalDateTime start, LocalDateTime end) {
            this.start = start;
            this.end = end;
        }
    }
}