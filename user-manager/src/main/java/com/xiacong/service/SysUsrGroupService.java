package com.xiacong.service;

import com.xiacong.model.domain.SysUsrGroup;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 您好
* @description 针对表【sys_usr_group(用户-用户组关联表)】的数据库操作Service
* @createDate 2024-05-22 15:36:49
*/
public interface SysUsrGroupService extends IService<SysUsrGroup> {

    List<SysUsrGroup> getUserGroupByUsrNo(String usrNo);
}
