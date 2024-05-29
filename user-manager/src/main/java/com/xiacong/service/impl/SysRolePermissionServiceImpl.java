package com.xiacong.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiacong.model.domain.SysRolePermission;
import com.xiacong.service.SysRolePermissionService;
import com.xiacong.mapper.SysRolePermissionMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
* @author 您好
* @description 针对表【sys_role_permission(角色-权限关联表)】的数据库操作Service实现
* @createDate 2024-05-22 15:36:49
*/
@Service
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermission>
    implements SysRolePermissionService{
    @Resource
    private SysRolePermissionMapper mapper;

    @Override
    public List<SysRolePermission> rolePermissionsByRoleCodes(Collection<String> roleCode) {
        return mapper.selectAllByRoleCodes(roleCode);
    }
}




