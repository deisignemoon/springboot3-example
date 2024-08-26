package com.xiacong.provider;

import com.alibaba.fastjson2.JSONObject;
import com.xiacong.common.api.IModelCallback;
import com.xiacong.common.request.RequestDTO;
import com.xiacong.common.result.ResultVO;
import com.xiacong.service.IPayService;
import jakarta.annotation.Resource;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 *
 *
 * @author xiacong
 * @Classname PayProviderImpl
 * @Version 1.0.0
 * @Date 2024/8/26 9:35
 * @Created by xiacong
 */
@DubboService
@Service
public class PayProviderImpl implements IModelCallback {
    @Resource
    private IPayService payService;

    @Override
    public ResultVO<String> callback(RequestDTO<String> dto) {
        JSONObject jsonObject = JSONObject.parseObject(dto.getData());
        String accountSrc = jsonObject.getString("accountSrc");
        String accountDest = jsonObject.getString("accountDest");
        BigDecimal amt = jsonObject.getBigDecimal("amt");
        if (payService.pay(accountSrc, accountDest, amt)) {
            return ResultVO.ok("SUCCESS");
        }
        return ResultVO.ok("FAIL");
    }
}
