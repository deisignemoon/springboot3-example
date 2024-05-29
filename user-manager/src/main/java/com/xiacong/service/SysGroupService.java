package com.xiacong.service;

import com.xiacong.model.domain.SysGroup;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 您好
* @description 针对表【sys_group(用户组表)】的数据库操作Service
* @createDate 2024-05-22 15:36:49
*/
public interface SysGroupService extends IService<SysGroup> {

    List<SysGroup> getGroupByUsrNo(String usrNo);
}
