package com.xiacong.utils.tencent;

import com.alibaba.fastjson2.JSONObject;
import com.xiacong.utils.tencent.model.HttpSSEReqDTO;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSources;


@Slf4j
public class HttpSSE {

    private String sseUrl; // SSE 服务器的 URL

    private String appKey;

    /**
     * 发送 SSE 请求
     */
    public void sseInvoke(HttpSSEReqDTO dto, SSEListener listener) {
        dto.setBot_app_key(appKey);
        // 创建 OkHttpClient 对象
        OkHttpClient client = new OkHttpClient();
        // 创建 JSON 请求体
        MediaType mediaType = MediaType.get("application/json");
        String reqBody = JSONObject.toJSONString(dto);
        log.info("请求参数：{}", reqBody);
        Request request = new Request.Builder()
                .url(sseUrl)
                .post(RequestBody.create(reqBody, mediaType))
                .build();
        EventSource.Factory factory = EventSources.createFactory(client);
        factory.newEventSource(request, listener);
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public void setSseUrl(String sseUrl) {
        this.sseUrl = sseUrl;
    }
}