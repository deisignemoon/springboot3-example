package com.xiacong.mapper;
import java.util.Collection;

import com.xiacong.model.domain.SysGroup;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 您好
* @description 针对表【sys_group(用户组表)】的数据库操作Mapper
* @createDate 2024-05-22 15:36:49
* @Entity com.xiacong.model.domain.SysGroup
*/
public interface SysGroupMapper extends BaseMapper<SysGroup> {

    List<SysGroup> selectAllByGroupCodes(@Param("groupCodeList") Collection<String> groupCodeList);
}




