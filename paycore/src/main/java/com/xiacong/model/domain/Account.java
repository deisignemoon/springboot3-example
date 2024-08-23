package com.xiacong.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName account
 */
@TableName(value ="account")
@Data
public class Account implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 账户号
     */
    private String accountNo;

    /**
     * 账户名称
     */
    private String accountName;

    /**
     * 账户类型
     */
    private String accountType;

    /**
     * 账户余额
     */
    private BigDecimal over;

    /**
     * 
     */
    private String createBy;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private String modifyBy;

    /**
     * 
     */
    private Date modifyTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}