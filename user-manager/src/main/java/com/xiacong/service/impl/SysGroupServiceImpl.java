package com.xiacong.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiacong.mapper.SysGroupMapper;
import com.xiacong.model.domain.SysGroup;
import com.xiacong.model.domain.SysUsrGroup;
import com.xiacong.service.SysGroupRoleService;
import com.xiacong.service.SysGroupService;
import com.xiacong.service.SysUsrGroupService;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 您好
 * @description 针对表【sys_group(用户组表)】的数据库操作Service实现
 * @createDate 2024-05-22 15:36:49
 */
@Service
public class SysGroupServiceImpl extends ServiceImpl<SysGroupMapper, SysGroup>
        implements SysGroupService {

    @Resource
    private SysUsrGroupService usrGroupService;
    @Resource
    private SysGroupRoleService groupRoleService;
    @Resource
    private SysGroupMapper mapper;

    @Override
    public List<SysGroup> getGroupByUsrNo(String usrNo) {
        if (StringUtils.isBlank(usrNo)) {
            return new ArrayList<>();
        }
        List<SysUsrGroup> userGroups = usrGroupService.getUserGroupByUsrNo(usrNo);
        if (CollectionUtils.isEmpty(userGroups)) {
            return new ArrayList<>();
        }
        List<String> groupCodes = userGroups.stream().map(SysUsrGroup::getGroupCode).toList();
        return mapper.selectAllByGroupCodes(groupCodes);
    }
}




