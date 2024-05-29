package com.xiacong.model.aggreate;

import com.xiacong.common.repository.Aggregate;
import com.xiacong.model.domain.SysGroup;
import com.xiacong.model.domain.SysPermission;
import com.xiacong.model.domain.SysRole;
import com.xiacong.model.domain.SysUsr;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Set;

/**
 * @author xiacong
 * @Classname UserAggreate
 * @Version 1.0.0
 * @Date 2024/5/10 9:26
 * @Created by xiacong
 */
@Setter
@Getter
public class UserAggreate extends User implements Aggregate {

    /**
     * 用户信息
     */
    private SysUsr user;

    /**
     * 权限信息
     */
    private Set<SysPermission> permissions;

    /**
     * 角色信息
     */
    private Set<SysRole> roles;

    /**
     * 用户组信息
     */
    private Set<SysGroup> userGroups;

    //todo 构建方式优化
    public UserAggreate(SysUsr user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getUsrName(), user.getPasswd(), user.getStatus(), user.getDelStatus(), true, true, authorities);
        this.user = user;
    }

}
