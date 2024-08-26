package com.xiacong.service;

import com.xiacong.model.domain.Account;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;

/**
* @author 您好
* @description 针对表【account】的数据库操作Service
* @createDate 2024-08-23 16:55:47
*/
public interface AccountService extends IService<Account> {

    Boolean updateAccountAmt(String accountNo, BigDecimal amt);

}
