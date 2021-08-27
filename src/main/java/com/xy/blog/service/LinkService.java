package com.xy.blog.service;

import com.xy.blog.entity.Link;

import java.util.List;

/**
 * @author 夕阳
 * @Description:
 */
public interface LinkService {

    /**
     * 添加链接
     * @param link
     */
    void saveLink(Link link);

    /**
     * 删除链接
     * @param linkId
     */
    void deleteLink(Long linkId);

    /**
     * 修改链接
     * @param link
     */
    void updateLink(Link link);

    /**
     * 很具id查询链接
     * @param linkId
     */
    Link getLinkById(Long linkId);

    /**
     * 获取所有链接
     * @return
     */
    List<Link> getListLink();
}
