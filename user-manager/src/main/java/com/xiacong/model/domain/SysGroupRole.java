package com.xiacong.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 用户组-角色关联表
 * @TableName sys_group_role
 */
@TableName(value ="sys_group_role")
@Data
public class SysGroupRole implements Serializable {
    /**
     * 用户组编号
     */
    private String groupCode;

    /**
     * 角色编号
     */
    private String roleCode;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}