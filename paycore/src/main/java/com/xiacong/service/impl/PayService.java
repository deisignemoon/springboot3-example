package com.xiacong.service.impl;

import com.xiacong.service.AccountService;
import com.xiacong.service.IPayService;
import com.xiacong.service.PostingFlowService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 *
 *
 * @author xiacong
 * @Classname PayService
 * @Version 1.0.0
 * @Date 2024/8/26 9:26
 * @Created by xiacong
 */
@Service
public class PayService implements IPayService {
    @Resource
    private AccountService accountService;
    @Resource
    private PostingFlowService postingFlowService;

    @Override
    @Transactional
    public Boolean pay(String accountSrc, String accountDest, BigDecimal amt) {
        accountService.updateAccountAmt(accountSrc,amt.negate());
        accountService.updateAccountAmt(accountDest,amt);
        postingFlowService.saveFlow(accountSrc,accountDest,amt);
        return true;
    }
}
