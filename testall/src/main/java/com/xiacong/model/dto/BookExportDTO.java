package com.xiacong.model.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName book
 */
@Data
@Table(name = "书籍表")
public class BookExportDTO implements Serializable {
    /**
     * 
     */
    @Column(name = "id")
    private Long id;

    /**
     * 
     */
    @Column(name = "书籍名称")
    private String name;

    /**
     * 
     */
    @Column(name = "年龄限制")
    private Integer ageRating;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}