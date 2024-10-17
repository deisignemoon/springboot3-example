package com.xiacong.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiacong.mapper.SysRoleMapper;
import com.xiacong.model.domain.SysGroupRole;
import com.xiacong.model.domain.SysRole;
import com.xiacong.model.domain.SysUsrRole;
import com.xiacong.service.SysGroupRoleService;
import com.xiacong.service.SysRoleService;
import com.xiacong.service.SysUsrRoleService;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.NullRoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author 您好
 * @description 针对表【sys_role(角色表)】的数据库操作Service实现
 * @createDate 2024-05-22 15:36:49
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole>
        implements SysRoleService {

    @Resource
    private SysGroupRoleService groupRoleService;

    @Resource
    private SysUsrRoleService usrRoleService;
    @Resource
    private SysRoleMapper mapper;

    @Override
    public List<SysRole> getRolesByGroupCodes(Collection<String> groupCodes) {
        if (CollectionUtils.isEmpty(groupCodes)) {
            return new ArrayList<>();
        }
        List<SysGroupRole> groupRoles = groupRoleService.getGroupRolesByGroupCodes(groupCodes);
        if (CollectionUtils.isEmpty(groupRoles)) {
            return new ArrayList<>();
        }
        List<String> roleCodes = groupRoles.stream().map(SysGroupRole::getRoleCode).toList();
        return mapper.selectAllByRoleCodes(roleCodes);
    }

    @Override
    public List<SysRole> getRolesByUsrNo(String usrNo) {
        if (StringUtils.isBlank(usrNo)) {
            return new ArrayList<>();
        }
        List<SysUsrRole> usrRoles = usrRoleService.getUsrRolesByUsrNo(usrNo);
        if (CollectionUtils.isEmpty(usrRoles)) {
            return new ArrayList<>();
        }
        List<String> roleCodes = usrRoles.stream().map(SysUsrRole::getRoleCode).toList();
        return mapper.selectAllByRoleCodes(roleCodes);
    }

    /**
     * 配置角色继承关系
     * @return
     */
    @Bean
    RoleHierarchy roleHierarchy() {
        List<SysRole> roles = mapper.selectAllByDelStatus(0);
        if (CollectionUtils.isEmpty(roles)) {
            return new NullRoleHierarchy();
        }
        RoleHierarchyImpl.Builder builder = RoleHierarchyImpl.withDefaultRolePrefix();
        roles.forEach(role -> {
            String roleCode = role.getRoleCode();
            String parentRoleNo = role.getParentRoleNo();
            if (StringUtils.isBlank(parentRoleNo)) {
                return;
            }
            builder.role(parentRoleNo).implies(roleCode);
        });
        return builder.build();
    }

    @Bean
    MethodSecurityExpressionHandler methodSecurityExpressionHandler(RoleHierarchy roleHierarchy) {
        DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
        expressionHandler.setRoleHierarchy(roleHierarchy);
        return expressionHandler;
    }
}




