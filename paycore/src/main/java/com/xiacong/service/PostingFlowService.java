package com.xiacong.service;

import com.xiacong.model.domain.PostingFlow;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;

/**
* @author 您好
* @description 针对表【posting_flow】的数据库操作Service
* @createDate 2024-08-23 16:56:03
*/
public interface PostingFlowService extends IService<PostingFlow> {

    Boolean saveFlow(String accountSrc, String accountDest, BigDecimal amt);

}
