package com.xiacong.service;

import com.xiacong.model.domain.SysGroupRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Collection;
import java.util.List;

/**
* @author 您好
* @description 针对表【sys_group_role(用户组-角色关联表)】的数据库操作Service
* @createDate 2024-05-22 15:36:49
*/
public interface SysGroupRoleService extends IService<SysGroupRole> {

    List<SysGroupRole> getGroupRolesByGroupCodes(Collection<String> groupCodes);
}
