package com.xiacong.service;

import com.xiacong.model.domain.SysPermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Collection;
import java.util.List;

/**
* @author 您好
* @description 针对表【sys_permission(权限表)】的数据库操作Service
* @createDate 2024-05-22 15:36:49
*/
public interface SysPermissionService extends IService<SysPermission> {

    List<SysPermission> permissionsByRoleCodes(Collection<String> roleCode);

}
