package com.xiacong.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 用户-角色关联表
 * @TableName sys_usr_role
 */
@TableName(value ="sys_usr_role")
@Data
public class SysUsrRole implements Serializable {
    /**
     * 用户编号
     */
    private String usrNo;

    /**
     * 角色编号
     */
    private String roleCode;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}