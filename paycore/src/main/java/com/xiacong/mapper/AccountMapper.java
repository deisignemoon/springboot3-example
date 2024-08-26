package com.xiacong.mapper;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiacong.model.domain.Account;
import org.apache.ibatis.annotations.Param;

/**
 * @author 您好
 * @description 针对表【account】的数据库操作Mapper
 * @createDate 2024-08-23 16:55:47
 * @Entity com.xiacong.model.domain.Account
 */
public interface AccountMapper extends BaseMapper<Account> {

    Account queryAllByAccountNo(@Param("accountNo") String accountNo);

    int updateOverByAccountNo(@Param("over") BigDecimal over, @Param("accountNo") String accountNo);
    int debitOverByAccountNo(@Param("over") BigDecimal over, @Param("accountNo") String accountNo);
}




