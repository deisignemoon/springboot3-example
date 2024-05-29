package com.xiacong.service;

import com.xiacong.model.domain.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Collection;
import java.util.List;

/**
* @author 您好
* @description 针对表【sys_role(角色表)】的数据库操作Service
* @createDate 2024-05-22 15:36:49
*/
public interface SysRoleService extends IService<SysRole> {

    /**
     * 根据用户组code查询角色
     * @param groupCodes
     * @return
     */
    List<SysRole> getRolesByGroupCodes(Collection<String> groupCodes);

    /**
     * 根据用户编号查询角色
     * @param usrNo
     * @return
     */
    List<SysRole> getRolesByUsrNo(String usrNo);
}
