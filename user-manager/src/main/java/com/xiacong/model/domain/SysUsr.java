package com.xiacong.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 用户表
 *
 * @TableName sys_usr
 */
@TableName(value = "sys_usr")
@Data
public class SysUsr implements Serializable {
    /**
     *
     */
    @TableId
    private Integer id;

    /**
     * 用户编号
     */
    private String usrNo;

    /**
     * 用户姓名
     */
    private String usrName;

    /**
     * 生日
     */
    //@JsonDeserialize(using = LocalDateDeserializer.class)  //反序列化
    //@JsonSerialize(using = LocalDateSerializer.class)  //序列化
    private LocalDate birthday;

    /**
     * 密码
     */
    private String passwd;

    /**
     * 生效状态
     */
    private Boolean status;

    /**
     * 删除状态
     */
    private Boolean delStatus;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

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
}