package com.xiacong.service.impl;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.lke.v20231130.LkeClient;
import com.tencentcloudapi.lke.v20231130.models.GetMsgRecordRequest;
import com.tencentcloudapi.lke.v20231130.models.GetMsgRecordResponse;
import com.tencentcloudapi.lke.v20231130.models.MsgRecord;
import com.xiacong.service.TencentLkeService;
import com.xiacong.utils.tencent.HttpSSE;
import com.xiacong.utils.tencent.SSEListener;
import com.xiacong.utils.tencent.model.HttpSSEReqDTO;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 *
 *
 * @author xiacong
 * @Classname TencentLkeServiceImpl
 * @Version 1.0.0
 * @Date 2025/4/17 15:21
 * @Created by xiacong
 */
@Service
@Configuration
public class TencentLkeServiceImpl implements TencentLkeService {

    @Value("${tencent.cloud.lke.appkey}")
    public String APPKEY;
    @Resource
    private HttpSSE httpSSE;
    @Resource
    private SSEListener sseListener;
    @Resource
    private Credential credential;

    private static final String VISITOR_BIZ_ID = "123456789";


    @Override
    public void completion(String message, String sessionId, HttpServletResponse rp) {
        if (StringUtils.isBlank(sessionId)) {
            sessionId = UUID.randomUUID().toString();
        }
        String reqId = UUID.randomUUID().toString();
        sseListener.setRp(rp);
        HttpSSEReqDTO dto = new HttpSSEReqDTO();
        dto.setContent(message);
        dto.setRequest_id(reqId);
        dto.setSession_id(sessionId);
        dto.setVisitor_biz_id(VISITOR_BIZ_ID);
        httpSSE.sseInvoke(dto, sseListener);
    }

    @Override
    public List<MsgRecord> history(String sessionId) {
        if (StringUtils.isBlank(sessionId)) {
            sessionId = UUID.randomUUID().toString();
        }
        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setRootDomain("tencentcloudapi.com");
        httpProfile.setReqMethod(HttpProfile.REQ_POST);
        httpProfile.setProtocol(HttpProfile.REQ_HTTPS);

        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);

        List<MsgRecord> list = new ArrayList<>();
        LkeClient client = new LkeClient(credential, "ap-guangzhou", clientProfile);
        GetMsgRecordRequest request = new GetMsgRecordRequest();
        request.setBotAppKey(APPKEY);
        request.setCount(15L);
        request.setSessionId(sessionId);
        request.setType(5L);
        try {
            GetMsgRecordResponse resp = client.GetMsgRecord(request);
            MsgRecord[] records = resp.getRecords();
            list.addAll(Arrays.asList(records));
        } catch (TencentCloudSDKException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
