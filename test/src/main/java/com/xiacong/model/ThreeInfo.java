package com.xiacong.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 示例表
 * @TableName three_info
 */
public class ThreeInfo implements Serializable {

    /**
     *
     */
    private Integer id;
    /**
     * 三方名称
     */
    private String threeName;
    /**
     * 三方密钥
     */
    private String threeSecret;
    /**
     * 三方key
     */
    private String threeKey;
    /**
     * 备注
     */
    private String remark;
    /**
     * 状态（0.启用 1.禁用）
     */
    private String status;
    /**
     *
     */
    private Date createTime;
    /**
     *
     */
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getThreeName() {
        return threeName;
    }

    public void setThreeName(String threeName) {
        this.threeName = threeName;
    }

    public String getThreeSecret() {
        return threeSecret;
    }

    public void setThreeSecret(String threeSecret) {
        this.threeSecret = threeSecret;
    }

    public String getThreeKey() {
        return threeKey;
    }

    public void setThreeKey(String threeKey) {
        this.threeKey = threeKey;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
