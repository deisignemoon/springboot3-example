package com.xiacong.mapper;

import com.xiacong.model.domain.SysRolePermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

/**
* @author 您好
* @description 针对表【sys_role_permission(角色-权限关联表)】的数据库操作Mapper
* @createDate 2024-05-22 15:36:49
* @Entity com.xiacong.model.domain.SysRolePermission
*/
public interface SysRolePermissionMapper extends BaseMapper<SysRolePermission> {

   List<SysRolePermission> selectAllByRoleCodes(@Param("roleCodeList") Collection<String> roleCodeList);
}




