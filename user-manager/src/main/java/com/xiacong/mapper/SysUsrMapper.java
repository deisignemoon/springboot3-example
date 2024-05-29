package com.xiacong.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiacong.model.domain.SysUsr;
import org.apache.ibatis.annotations.Param;

/**
* @author 您好
* @description 针对表【sys_usr(用户表)】的数据库操作Mapper
* @createDate 2024-05-09 14:50:08
* @Entity com.xiacong.model.domain.SysUsr
*/
public interface SysUsrMapper extends BaseMapper<SysUsr> {

    SysUsr selectByUsrName(@Param("usrName") String usrName);
}




