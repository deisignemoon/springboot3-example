package com.xiacong.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiacong.model.domain.SysGroupRole;
import com.xiacong.service.SysGroupRoleService;
import com.xiacong.mapper.SysGroupRoleMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
* @author 您好
* @description 针对表【sys_group_role(用户组-角色关联表)】的数据库操作Service实现
* @createDate 2024-05-22 15:36:49
*/
@Service
public class SysGroupRoleServiceImpl extends ServiceImpl<SysGroupRoleMapper, SysGroupRole>
    implements SysGroupRoleService{
    @Resource
    private SysGroupRoleMapper mapper;

    @Override
    public List<SysGroupRole> getGroupRolesByGroupCodes(Collection<String> groupCodes) {
        return mapper.selectAllByGroupCodes(groupCodes);
    }
}




