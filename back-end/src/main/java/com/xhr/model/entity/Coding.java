package com.xhr.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * coding
 * @TableName coding
 */
@TableName(value ="coding")
@Data
public class Coding implements Serializable {
    /**
     * bid
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * Name
     */
    private String skillName;

    /**
     * Level
     */
    private String skillLevel;

    /**
     * Describe
     */
    private String skillDescribe;

    /**
     * createTime
     */
    private Date createTime;

    /**
     * updateTime
     */
    private Date updateTime;

    /**
     * isDelete
     */
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}