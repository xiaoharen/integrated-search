package com.xhr.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * footprint
 * @TableName footprint
 */
@TableName(value ="footprint")
@Data
public class Footprint implements Serializable {
    /**
     * bid
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * title
     */
    private String place;

    /**
     * label
     */
    private String happenTime;

    /**
     * essay id
     */
    private Long eid;

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