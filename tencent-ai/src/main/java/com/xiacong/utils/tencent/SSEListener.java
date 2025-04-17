package com.xiacong.utils.tencent;

import com.alibaba.fastjson2.JSONObject;
import com.xiacong.utils.tencent.model.HttpSSEReqDTO;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.concurrent.CountDownLatch;

@Slf4j
@Data
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SSEListener extends EventSourceListener {

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    private HttpSSEReqDTO chatGlmDto;

    private HttpServletResponse rp;

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
            //todo 数据库保存消息
            if (type.equals("reply")) {
                JSONObject dataObj = JSONObject.parseObject(data);
                String payload = dataObj.getString("payload");
                //HttpSSERespReplyDTO reply = JSONObject.parseObject(payload, HttpSSERespReplyDTO.class);
                rp.getWriter().write(payload);
                rp.getWriter().flush();
            } else {
                System.out.println("Received SSE event: " + type);
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
        countDownLatch.countDown();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onFailure(final EventSource eventSource, final Throwable t, final Response response) {
        log.error("使用事件源时出现异常... [响应：{}]...", chatGlmDto.getRequest_id());
        countDownLatch.countDown();
    }

    public CountDownLatch getCountDownLatch() {
        return this.countDownLatch;
    }
}

