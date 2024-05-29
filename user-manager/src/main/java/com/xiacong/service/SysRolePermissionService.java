package com.xiacong.service;

import com.xiacong.model.domain.SysRolePermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Collection;
import java.util.List;

/**
* @author 您好
* @description 针对表【sys_role_permission(角色-权限关联表)】的数据库操作Service
* @createDate 2024-05-22 15:36:49
*/
public interface SysRolePermissionService extends IService<SysRolePermission> {

    List<SysRolePermission> rolePermissionsByRoleCodes(Collection<String> roleCode);
}
