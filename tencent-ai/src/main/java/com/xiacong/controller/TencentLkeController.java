package com.xiacong.controller;

import com.alibaba.fastjson2.JSONObject;
import com.tencentcloudapi.lke.v20231130.models.MsgRecord;
import com.xiacong.service.TencentLkeService;
import com.xiacong.utils.tencent.TestListener;
import jakarta.annotation.Nullable;
import jakarta.annotation.Resource;
import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;
import okhttp3.sse.EventSources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 * @author xiacong
 * @Classname TencentLkeController
 * @Version 1.0.0
 * @Date 2025/4/17 14:06
 * @Created by xiacong
 */
@RestController
@RequestMapping("/ai")
@Slf4j
public class TencentLkeController {

    @Resource
    private TencentLkeService service;

    @GetMapping(value = "/chat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter completion(@RequestParam(value = "message") String message, @RequestParam(value = "sessionid", required = false) String sessionId) {
        SseEmitter sseEmitter = new SseEmitter();
        service.completion(message, sessionId, sseEmitter);
        return sseEmitter;
    }

    @GetMapping(value = "/chat2")
    public void completion2(@RequestParam(value = "message") String message, @RequestParam(value = "sessionid", required = false) String sessionId,
                                  HttpServletRequest req, HttpServletResponse resp) {
        // text/event-stream 是一个特殊的MIME类型，用于定义Server-Sent Events (SSE)。它告诉浏览器这个响应是SSE流，浏览器应该以这种方式处理接收到的数据。
        resp.setContentType("text/event-stream");
        resp.setCharacterEncoding("UTF-8");
        // 这行代码设置了Cache-Control HTTP头部字段，值为no-cache。这意味着浏览器不应该缓存此响应。对于SSE来说，这是很重要的，因为我们希望实时更新数据，而不希望浏览器缓存旧的数据。
        resp.setHeader("Cache-Control", "no-cache");
        // 这行代码设置了Connection HTTP头部字段，值为keep-alive。这意味着客户端和服务器之间的TCP连接在响应完成后保持打开状态，以便后续的SSE事件可以通过同一个连接发送。这对于持续的数据流非常重要，因为它减少了建立新连接的开销。
        resp.setHeader("Connection", "keep-alive");
        PrintWriter writer=null;
        try {
            AsyncContext asyncContext = req.startAsync(req, resp);
            asyncContext.setTimeout(10 * 60 * 1000);
            writer = asyncContext.getResponse().getWriter();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        service.completion2(message, sessionId, writer);
    }

    @GetMapping("/history")
    public List<MsgRecord> history(@RequestParam(value = "sessionId") String sessionId) {
        return service.history(sessionId);
    }

    @GetMapping("/getmessage")
    public void sendMsg(HttpServletResponse response) throws Exception {
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        ServletOutputStream outputStream = response.getOutputStream();
        TestListener listener = new TestListener();
        listener.setOutputStream(outputStream);
        while (true) {
            listener.onEvent(null, null, null, "你好");
            Thread.sleep(1000);
        }
    }

    private void write(HttpServletResponse response, String content) throws IOException {
        response.getWriter().write(content + "");
        response.flushBuffer();
        response.getWriter().flush();

    }

    @GetMapping(value = "/test1", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter SseTest1() {
        SseEmitter sseEmitter = new SseEmitter();
        String prompt = "";
        String url = "";
        FormBody formBody = new FormBody.Builder().add("prompt", prompt).build();
        Request request = new Request.Builder().url(url).post(formBody).build();
        // 使用EventSourceListener处理来自服务器的SSE事件
        EventSourceListener listener = new EventSourceListener() {
            @Override
            public void onOpen(@NotNull EventSource eventSource, @NotNull Response response) {
                log.info("Connection opened.");
            }

            @Override
            public void onClosed(@NotNull EventSource eventSource) {
                log.info("Connection closed.");
                sseEmitter.complete();
            }

            @Override
            public void onEvent(@NotNull EventSource eventSource, @Nullable String id, @Nullable String type, @NotNull String data) {
                try {
                    JSONObject jsonObject = JSONObject.parseObject(data);
                    String event = jsonObject.getString("event");
                    if ("message".equals(event)) {
                        sseEmitter.send(jsonObject.getString("answer"));
                    }
                } catch (Exception e) {
                    log.error("推送数据失败", e);
                }
            }

            @Override
            public void onFailure(@NotNull EventSource eventSource, @Nullable Throwable t, @Nullable Response response) {
                log.error("Connection failed.", t);
                sseEmitter.completeWithError(t);
            }
        };
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).writeTimeout(50, TimeUnit.SECONDS).readTimeout(10, TimeUnit.MINUTES).build();
        EventSource.Factory factory = EventSources.createFactory(client);
        factory.newEventSource(request, listener);
        return sseEmitter;
    }

    @GetMapping("/test3")
    public void sseTest3(HttpServletRequest req, HttpServletResponse resp) {
        // text/event-stream 是一个特殊的MIME类型，用于定义Server-Sent Events (SSE)。它告诉浏览器这个响应是SSE流，浏览器应该以这种方式处理接收到的数据。
        resp.setContentType("text/event-stream");
        resp.setCharacterEncoding("UTF-8");
        // 这行代码设置了Cache-Control HTTP头部字段，值为no-cache。这意味着浏览器不应该缓存此响应。对于SSE来说，这是很重要的，因为我们希望实时更新数据，而不希望浏览器缓存旧的数据。
        resp.setHeader("Cache-Control", "no-cache");
        // 这行代码设置了Connection HTTP头部字段，值为keep-alive。这意味着客户端和服务器之间的TCP连接在响应完成后保持打开状态，以便后续的SSE事件可以通过同一个连接发送。这对于持续的数据流非常重要，因为它减少了建立新连接的开销。
        resp.setHeader("Connection", "keep-alive");

        try {
            // 创建一个AsyncContext对象并开启异步处理流程
            AsyncContext asyncContext = req.startAsync(req, resp);
            asyncContext.setTimeout(10 * 60 * 1000);
            PrintWriter writer = asyncContext.getResponse().getWriter();

            String prompt = "";
            String url = "";
            FormBody formBody = new FormBody.Builder().add("prompt", prompt).build();
            Request request = new Request.Builder().url(url).post(formBody).build();
            // 使用EventSourceListener处理来自服务器的SSE事件
            EventSourceListener listener = new EventSourceListener() {
                @Override
                public void onOpen(@NotNull EventSource eventSource, @NotNull Response response) {
                    log.info("Connection opened.");
                }

                @Override
                public void onClosed(@NotNull EventSource eventSource) {
                    log.info("Connection closed.");
                    writer.write("data: __stop__");
                    writer.flush();
                    asyncContext.complete();
                }

                @Override
                public void onEvent(@NotNull EventSource eventSource, @Nullable String id, @Nullable String type, @NotNull String data) {
                    try {
                        JSONObject jsonObject = JSONObject.parseObject(data);
                        String event = jsonObject.getString("event");
                        if ("message".equals(event)) {
                            String answer = jsonObject.getString("answer");
                            log.info("message: {}", answer);
                            writer.write("data: " + answer + "");
                            writer.flush();
                        }
                    } catch (Exception e) {
                        log.error("推送数据失败", e);
                    }
                }

                @Override
                public void onFailure(@NotNull EventSource eventSource, @Nullable Throwable t, @Nullable Response response) {
                    log.error("Connection failed.", t);
                    asyncContext.complete();
                }
            };
            OkHttpClient client = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).writeTimeout(50, TimeUnit.SECONDS).readTimeout(10, TimeUnit.MINUTES).build();
            EventSource.Factory factory = EventSources.createFactory(client);
            factory.newEventSource(request, listener);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
