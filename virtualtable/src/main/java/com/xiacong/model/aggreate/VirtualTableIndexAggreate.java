package com.xiacong.model.aggreate;

import com.xiacong.common.repository.Aggregate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 虚拟表索引表
 * </p>
 *
 * @author xiacong
 * @since 2023-10-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class VirtualTableIndexAggreate implements Aggregate {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String tabelName;

    /**
     * 键值，使用“-”拼接
     */
    private String indexValue;

    /**
     * 索引值
     */
    private String pkValue;

    private Date gmtCreate;

    private Date gmtModified;


}
