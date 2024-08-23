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
 * @TableName posting_flow
 */
@TableName(value ="posting_flow")
@Data
public class PostingFlow implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String accountSrc;

    /**
     * 
     */
    private String accountDest;

    /**
     * 
     */
    private BigDecimal amt;

    /**
     * 
     */
    private String createBy;

    /**
     * 
     */
    private String modifyBy;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date modifyTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}