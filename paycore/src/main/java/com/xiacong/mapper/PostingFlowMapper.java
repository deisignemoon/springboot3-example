package com.xiacong.mapper;

import com.xiacong.model.domain.PostingFlow;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
* @author 您好
* @description 针对表【posting_flow】的数据库操作Mapper
* @createDate 2024-08-23 16:56:03
* @Entity com.xiacong.model.domain.PostingFlow
*/
public interface PostingFlowMapper extends BaseMapper<PostingFlow> {
    int saveByParam(@Param("amt") BigDecimal amt, @Param("accountSrc") String accountSrc,@Param("accountDest") String accountDest);
}




