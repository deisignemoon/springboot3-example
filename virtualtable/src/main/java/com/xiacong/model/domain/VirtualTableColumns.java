package com.xiacong.model.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 虚拟表字段定义表
 * </p>
 *
 * @author xiacong
 * @since 2023-10-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class VirtualTableColumns implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 字段名称
     */
    private String columnId;

    /**
     * 字段描述
     */
    private String columnName;

    /**
     * 字段数据类型
     */
    private String columnType;

    /***
     * 排序
     */
    private Integer sort;

    /**
     * 描述
     */
    private String memo;

    /**
     * 是否为键，0-普通字段，1-键字段
     */
    private String keySts;

    /**
     * 是否删除，0-未删除，1-已删除
     */
    private String deleteSts;

    private Date gmtCreate;

    private Date gmtModified;


}
