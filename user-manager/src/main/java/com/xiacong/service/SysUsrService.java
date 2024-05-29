package com.xiacong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiacong.model.domain.SysUsr;

/**
 * @author 您好
 * @description 针对表【sys_usr(用户表)】的数据库操作Service
 * @createDate 2024-05-09 14:50:08
 */
public interface SysUsrService extends IService<SysUsr> {
    SysUsr findByUsrName(String usrName);
}
