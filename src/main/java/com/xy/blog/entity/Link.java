package com.xy.blog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 夕阳
 * @Description:
 */
@Data
public class Link implements Serializable {

    private static final long serialVersionUID = -5127872549382069472L;

    /**
     * 自增id
     */
    private Long linkId;

    /**
     * 名称
     */
    private String linkName;

    /**
     * 链接地址
     */
    private String linkUrl;

    /**
     * 创建时间
     */
    private String createdTime;

    /**
     * 修改时间
     */
    private String updateTime;

    /**
     * 是否删除，1是0否
     */
    private Integer deleted;

}
