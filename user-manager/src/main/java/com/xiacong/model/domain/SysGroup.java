package com.xiacong.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import lombok.Data;

/**
 * 用户组表
 * @TableName sys_group
 */
@TableName(value ="sys_group")
@Data
public class SysGroup implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户组编号
     */
    private String groupCode;

    /**
     * 用户组名称
     */
    private String groupName;

    /**
     * 生效状态
     */
    private Integer status;

    /**
     * 删除状态
     */
    private Integer delStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 修改人
     */
    private String updateBy;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysGroup sysGroup = (SysGroup) o;
        return Objects.equals(groupCode, sysGroup.groupCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupCode);
    }
}