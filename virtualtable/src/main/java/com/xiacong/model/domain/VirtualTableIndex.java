package com.xiacong.model.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
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
public class VirtualTableIndex implements Serializable {

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

    private String deleteSts;

    private Date gmtCreate;

    private Date gmtModified;


}
