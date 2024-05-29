package com.xiacong.common.util;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.function.Supplier;

/**
 * @author xiacong
 * @Classname HttpUtil
 * @Version 1.0.0
 * @Date 2023/10/23 9:03
 * @Created by xiacong
 */
public class HttpUtil {

    public WebClient init(int timeout) {
        HttpClient httpClient =
                HttpClient.create()
                        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, timeout)
                        .responseTimeout(Duration.ofMillis(timeout))
                        .doOnConnected(conn -> conn.addHandlerLast(new ReadTimeoutHandler(timeout)));
        return WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient)).build();
    }

    public Mono<String> makePostRequestAsync(String baseUrl,String uri, String postData) {
        WebClient webClient = WebClient.builder().baseUrl(baseUrl).build();
        return webClient.post()
                .uri(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(postData)
                .retrieve()
                .bodyToMono(String.class);
    }
    public Mono<String> makeGetRequestAsync(String baseUrl,String uri) {
        WebClient webClient = WebClient.builder().baseUrl(baseUrl).build();
        return webClient.post()
                .uri(uri)
                .retrieve()
                .bodyToMono(String.class);
    }

}
