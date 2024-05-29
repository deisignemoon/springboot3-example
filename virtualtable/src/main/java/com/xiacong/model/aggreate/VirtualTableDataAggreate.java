package com.xiacong.model.aggreate;

import com.xiacong.common.repository.Aggregate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 虚拟表数据表
 * </p>
 *
 * @author xiacong
 * @since 2023-10-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class VirtualTableDataAggreate implements Aggregate {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 数据
     */
    private String fieldValue;

    /**
     * 键值
     */
    private String pkValue;

    /**
     * 是否删除（0-未删除，1-已删除）
     */
    private String deleteSts;

    private Date gmtCreate;

    private Date gmtModified;


}
