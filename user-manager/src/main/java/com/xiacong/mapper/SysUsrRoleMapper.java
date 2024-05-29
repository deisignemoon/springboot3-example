package com.xiacong.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import java.util.Collection;

import com.xiacong.model.domain.SysUsrRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 您好
* @description 针对表【sys_usr_role(用户-角色关联表)】的数据库操作Mapper
* @createDate 2024-05-22 15:36:49
* @Entity com.xiacong.model.domain.SysUsrRole
*/
public interface SysUsrRoleMapper extends BaseMapper<SysUsrRole> {

    List<SysUsrRole> selectAllByUsrNo(@Param("usrNo") String usrNo);
}




