package com.xiacong.utils.tencent;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;

import java.io.IOException;

@Slf4j
@Data
public class TestListener extends EventSourceListener {


    private ServletOutputStream outputStream;

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
            String payload = data;
            //HttpSSERespReplyDTO reply = JSONObject.parseObject(payload, HttpSSERespReplyDTO.class);
            log.info("返回数据：{}", payload);
            //rp.getWriter().write(payload);
            //rp.flushBuffer();
            //rp.getWriter().flush();
            outputStream.write(payload.getBytes());
            outputStream.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onClosed(final EventSource eventSource) {
        // 关闭连接时的处理逻辑
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onFailure(final EventSource eventSource, final Throwable t, final Response response) {
        // 关闭连接时的处理逻辑
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

