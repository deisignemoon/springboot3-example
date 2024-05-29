package com.xiacong.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiacong.model.domain.SysPermission;
import com.xiacong.model.domain.SysRolePermission;
import com.xiacong.service.SysPermissionService;
import com.xiacong.mapper.SysPermissionMapper;
import com.xiacong.service.SysRolePermissionService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
* @author 您好
* @description 针对表【sys_permission(权限表)】的数据库操作Service实现
* @createDate 2024-05-22 15:36:49
*/
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission>
    implements SysPermissionService{
    @Resource
    private SysRolePermissionService rolePermissionService;
    @Resource
    private SysPermissionMapper mapper;

    @Override
    public List<SysPermission> permissionsByRoleCodes(Collection<String> roleCode) {
        if (CollectionUtils.isEmpty(roleCode)) {
            return new ArrayList<>();
        }
        List<SysRolePermission> rolePermissions=rolePermissionService.rolePermissionsByRoleCodes(roleCode);
        if (CollectionUtils.isEmpty(rolePermissions)) {
            return new ArrayList<>();
        }
        List<String> permissionCodes=rolePermissions.stream().map(SysRolePermission::getPermissionCode).toList();
        return mapper.selectAllByPermissionCodes(permissionCodes);
    }
}




