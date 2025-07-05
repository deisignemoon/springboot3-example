package com.xiacong.utils.tencent;

import com.alibaba.fastjson2.JSONObject;
import com.xiacong.utils.tencent.model.HttpSSEReqDTO;
import com.xiacong.utils.tencent.model.HttpSSERespReplyDTO;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;

@Slf4j
//@Component
//@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SSEListener extends EventSourceListener {

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    private HttpSSEReqDTO chatGlmDto;

    private SseEmitter sseEmitter;
    private PrintWriter writer;

    private StringBuffer output = new StringBuffer();

    /**
     * {@inheritDoc}
     * 建立sse连接
     */
    @Override
    public void onOpen(final EventSource eventSource, final Response response) {
        log.info("建立sse连接...");
    }

    /**
     * 事件
     *
     * @param eventSource
     * @param id
     * @param type
     * @param data
     */
    @Override
    public void onEvent(EventSource eventSource, String id, String type, String data) {
        try {
            log.info("接收到sse消息：{}", data);
            log.info("Received SSE event: {}", type);
            //todo 数据库保存消息
            JSONObject dataObj = JSONObject.parseObject(data);
            //String payload = dataObj.getString("payload");
            //HttpSSERespReplyDTO reply = JSONObject.parseObject(payload, HttpSSERespReplyDTO.class);
            log.info("返回数据：{}", data);
            if (sseEmitter!=null) {
                sseEmitter.send(data);
            }else {
                writer.write(data);
                writer.flush();
            }
        } catch (Exception e) {
            log.error("消息错误[" + JSONObject.toJSONString(chatGlmDto) + "]", e);
            countDownLatch.countDown();
            throw new RuntimeException(e);
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onClosed(final EventSource eventSource) {
        log.info("sse连接关闭:{}", chatGlmDto.getRequest_id());
        log.info("结果输出:{}" + output.toString());
        sseEmitter.complete();
        countDownLatch.countDown();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onFailure(final EventSource eventSource, final Throwable t, final Response response) {
        log.error("使用事件源时出现异常... [响应：{}]...", chatGlmDto.getRequest_id());
        sseEmitter.completeWithError(t);
        countDownLatch.countDown();
    }

    public CountDownLatch getCountDownLatch() {
        return this.countDownLatch;
    }

    public void setChatGlmDto(HttpSSEReqDTO chatGlmDto) {
        this.chatGlmDto = chatGlmDto;
    }

    public void setSseEmitter(SseEmitter sseEmitter) {
        this.sseEmitter = sseEmitter;
    }

    public void setWriter(PrintWriter writer) {
        this.writer = writer;
    }
}

