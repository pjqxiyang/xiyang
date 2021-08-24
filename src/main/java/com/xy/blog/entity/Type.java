package com.xy.blog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 夕阳
 * @Description:
 */
@Data
public class Type implements Serializable {

    private static final long serialVersionUID = 7720725040371022691L;

    /**
     * 分类id
     */
    private Long typeId;

    /**
     * 分类名称
     */
    private String typeName;

    /**
     * 帖子数
     */
    private Integer typeBlogCount;

    /**
     * 是否启用，1是0否
     */
    private Integer enable;

    /**
     * 是否删除，1是0否
     */
    private String deleted;


}
