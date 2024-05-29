package com.xiacong.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 角色-权限关联表
 * @TableName sys_role_permission
 */
@TableName(value ="sys_role_permission")
@Data
public class SysRolePermission implements Serializable {
    /**
     * 角色编号
     */
    private String roleCode;

    /**
     * 权限编号
     */
    private String permissionCode;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}