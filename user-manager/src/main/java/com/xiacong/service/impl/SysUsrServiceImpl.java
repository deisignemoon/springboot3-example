package com.xiacong.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiacong.mapper.SysUsrMapper;
import com.xiacong.model.domain.SysUsr;
import com.xiacong.service.SysUsrGroupService;
import com.xiacong.service.SysUsrRoleService;
import com.xiacong.service.SysUsrService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author 您好
 * @description 针对表【sys_usr(用户表)】的数据库操作Service实现
 * @createDate 2024-05-09 14:50:08
 */
@Service
@Slf4j
public class SysUsrServiceImpl extends ServiceImpl<SysUsrMapper, SysUsr>
        implements SysUsrService {
    @Resource
    private SysUsrMapper mapper;

    @Resource
    private SysUsrGroupService usrGroupService;

    @Resource
    private SysUsrRoleService usrRoleService;


    @Override
    public SysUsr findByUsrName(String usrName) {
        return mapper.selectByUsrName(usrName);
    }
}




