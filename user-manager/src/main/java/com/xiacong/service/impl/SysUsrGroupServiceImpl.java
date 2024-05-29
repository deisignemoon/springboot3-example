package com.xiacong.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiacong.model.domain.SysUsrGroup;
import com.xiacong.service.SysUsrGroupService;
import com.xiacong.mapper.SysUsrGroupMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 您好
* @description 针对表【sys_usr_group(用户-用户组关联表)】的数据库操作Service实现
* @createDate 2024-05-22 15:36:49
*/
@Service
public class SysUsrGroupServiceImpl extends ServiceImpl<SysUsrGroupMapper, SysUsrGroup>
    implements SysUsrGroupService{
    @Resource
    private SysUsrGroupMapper mapper;

    @Override
    public List<SysUsrGroup> getUserGroupByUsrNo(String usrNo) {
        return mapper.selectAllByUsrNo(usrNo);
    }
}




