package com.xiacong.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.xiacong.model.aggreate.UserAggreate;
import com.xiacong.model.domain.SysGroup;
import com.xiacong.model.domain.SysPermission;
import com.xiacong.model.domain.SysRole;
import com.xiacong.model.domain.SysUsr;
import com.xiacong.service.*;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private SysUsrService usrService;
    @Resource
    private SysGroupService groupService;
    @Resource
    private SysRoleService roleService;
    @Resource
    private SysPermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUsr sysUser = usrService.findByUsrName(username);
        if (Objects.isNull(sysUser)) {
            throw new UsernameNotFoundException("用户名不存在！");
        }

        if (sysUser.getStatus()) {
            throw new RuntimeException("账号已停用");
        }
        String usrNo = sysUser.getUsrNo();
        List<SysGroup> groups = groupService.getGroupByUsrNo(usrNo);
        Collection<SysRole> roles = roleService.getRolesByUsrNo(usrNo);
        Collection<SysRole> groupRoles = new ArrayList<>();
        if (CollectionUtils.isEmpty(groups)) {
            List<String> groupCodes = groups.stream().map(SysGroup::getGroupCode).collect(Collectors.toList());
            groupRoles = roleService.getRolesByGroupCodes(groupCodes);
        }
        Set<SysRole> roleSet = new HashSet<>();
        roleSet.addAll(roles);
        roleSet.addAll(groupRoles);
        Set<String> roleCodes = roleSet.stream().map(SysRole::getRoleCode).collect(Collectors.toSet());
        List<SysPermission> permissions = permissionService.permissionsByRoleCodes(roleCodes);
        Set<SysPermission> permissionSet = new HashSet<>(permissions);
        UserAggreate aggreate = new UserAggreate(sysUser, getPermissions(permissionSet));
        aggreate.setPermissions(permissionSet);
        aggreate.setRoles(roleSet);
        aggreate.setUserGroups(new HashSet<>(groups));
        log.debug("用户信息：{}", JSONObject.toJSONString(aggreate));
        return aggreate;
    }

    private List<GrantedAuthority> getPermissions(Collection<SysPermission> permissions) {
        if (CollectionUtils.isEmpty(permissions)) {
            return Collections.emptyList();
        }
        return permissions.stream().map(perm -> new SimpleGrantedAuthority(perm.getPermissionCode())).collect(Collectors.toList());
    }

}