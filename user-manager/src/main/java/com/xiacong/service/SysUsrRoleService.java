package com.xiacong.service;

import com.xiacong.model.domain.SysUsrRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 您好
* @description 针对表【sys_usr_role(用户-角色关联表)】的数据库操作Service
* @createDate 2024-05-22 15:36:49
*/
public interface SysUsrRoleService extends IService<SysUsrRole> {

    List<SysUsrRole> getUsrRolesByUsrNo(String usrNo);
}
