package com.xiacong.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.xiacong.model.domain.SysUsrGroup;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 您好
* @description 针对表【sys_usr_group(用户-用户组关联表)】的数据库操作Mapper
* @createDate 2024-05-22 15:36:49
* @Entity com.xiacong.model.domain.SysUsrGroup
*/
public interface SysUsrGroupMapper extends BaseMapper<SysUsrGroup> {
    List<SysUsrGroup> selectAllByUsrNo(@Param("usrNo") String usrNo);
}




