package com.xiacong.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 用户-用户组关联表
 * @TableName sys_usr_group
 */
@TableName(value ="sys_usr_group")
@Data
public class SysUsrGroup implements Serializable {
    /**
     * 用户编号
     */
    private String usrNo;

    /**
     * 用户组编号
     */
    private String groupCode;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}