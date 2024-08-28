package com.xxl.job.admin.provider;

import com.xiacong.common.api.IModelCallback;
import com.xiacong.common.request.RequestDTO;
import com.xiacong.common.result.ResultVO;
import com.xxl.job.admin.core.model.XxlJobInfo;
import com.xxl.job.admin.service.XxlJobService;
import com.xxl.job.core.biz.model.ReturnT;
import jakarta.annotation.Resource;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author xiacong
 * @Classname XxlJobProvider
 * @Version 1.0.0
 * @Date 2024/8/27 16:37
 * @Created by xiacong
 */
@DubboService
@Service
public class XxlJobProvider implements IModelCallback {
    @Resource
    private XxlJobService xxlJobService;
    @Override
    public ResultVO<String> callback(RequestDTO<String> dto) {
        String data = dto.getData();
        String path = dto.getPath();
        XxlJobInfo info = new XxlJobInfo();
        ReturnT<String> add = xxlJobService.add(info);
        return ResultVO.ok(add.getContent());
    }
}
