package com.xiacong.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiacong.model.domain.SysUsrRole;
import com.xiacong.service.SysUsrRoleService;
import com.xiacong.mapper.SysUsrRoleMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 您好
* @description 针对表【sys_usr_role(用户-角色关联表)】的数据库操作Service实现
* @createDate 2024-05-22 15:36:49
*/
@Service
public class SysUsrRoleServiceImpl extends ServiceImpl<SysUsrRoleMapper, SysUsrRole>
    implements SysUsrRoleService{
    @Resource
    private SysUsrRoleMapper mapper;

    @Override
    public List<SysUsrRole> getUsrRolesByUsrNo(String usrNo) {
        return mapper.selectAllByUsrNo(usrNo);
    }
}




