package com.xiacong.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import java.util.Collection;

import com.xiacong.model.domain.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 您好
* @description 针对表【sys_role(角色表)】的数据库操作Mapper
* @createDate 2024-05-22 15:36:49
* @Entity com.xiacong.model.domain.SysRole
*/
public interface SysRoleMapper extends BaseMapper<SysRole> {
    List<SysRole> selectAllByRoleCodes(@Param("roleCodeList") Collection<String> roleCodeList);

    List<SysRole> selectAllByDelStatus(@Param("delStatus") Integer delStatus);
}




