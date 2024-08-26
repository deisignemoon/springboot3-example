package com.xiacong.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiacong.mapper.PostingFlowMapper;
import com.xiacong.model.domain.PostingFlow;
import com.xiacong.service.PostingFlowService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author 您好
 * @description 针对表【posting_flow】的数据库操作Service实现
 * @createDate 2024-08-23 16:56:03
 */
@Service
public class PostingFlowServiceImpl extends ServiceImpl<PostingFlowMapper, PostingFlow>
        implements PostingFlowService {
    @Resource
    private PostingFlowMapper mapper;

    @Override
    public Boolean saveFlow(String accountSrc, String accountDest, BigDecimal amt) {
        int count = mapper.saveByParam(amt, accountSrc, accountDest);
        return count == 1;
    }
}




