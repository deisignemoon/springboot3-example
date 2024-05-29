package com.xiacong.model.aggreate;

import com.xiacong.common.repository.Aggregate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 虚拟表定义表
 * </p>
 *
 * @author xiacong
 * @since 2023-10-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class VirtualTableAggreate implements Aggregate {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 描述
     */
    private String memo;

    private Date gmtCreate;

    private Date gmtModified;


}
