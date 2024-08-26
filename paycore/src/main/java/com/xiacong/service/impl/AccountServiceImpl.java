package com.xiacong.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiacong.mapper.AccountMapper;
import com.xiacong.model.domain.Account;
import com.xiacong.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author 您好
 * @description 针对表【account】的数据库操作Service实现
 * @createDate 2024-08-23 16:55:47
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account>
        implements AccountService {
    @Resource
    private AccountMapper mapper;

    @Override
    public Boolean updateAccountAmt(String accountNo, BigDecimal amt) {
        int count = mapper.debitOverByAccountNo(amt, accountNo);
        return count == 1;
    }
}




