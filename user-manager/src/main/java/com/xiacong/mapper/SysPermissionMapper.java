package com.xiacong.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import java.util.Collection;

import com.xiacong.model.domain.SysPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 您好
* @description 针对表【sys_permission(权限表)】的数据库操作Mapper
* @createDate 2024-05-22 15:36:49
* @Entity com.xiacong.model.domain.SysPermission
*/
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    List<SysPermission> selectAllByPermissionCodes(@Param("permissionCodeList") Collection<String> permissionCodeList);
}




