package com.xiacong.common.api;

import com.xiacong.common.request.RequestDTO;
import com.xiacong.common.result.ResultVO;

/**
 * 模块回调通用接口
 *
 * @author xiacong
 * @Classname IModelCallback
 * @Version 1.0.0
 * @Date 2024/8/23 16:59
 * @Created by xiacong
 */
public interface IModelCallback {
    ResultVO<String> callback(RequestDTO dto);
}
