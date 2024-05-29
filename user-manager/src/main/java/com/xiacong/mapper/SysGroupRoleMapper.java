package com.xiacong.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import java.util.Collection;

import com.xiacong.model.domain.SysGroupRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 您好
* @description 针对表【sys_group_role(用户组-角色关联表)】的数据库操作Mapper
* @createDate 2024-05-22 15:36:49
* @Entity com.xiacong.model.domain.SysGroupRole
*/
public interface SysGroupRoleMapper extends BaseMapper<SysGroupRole> {

    List<SysGroupRole> selectAllByGroupCodes(@Param("groupCodeList") Collection<String> groupCodeList);
}




