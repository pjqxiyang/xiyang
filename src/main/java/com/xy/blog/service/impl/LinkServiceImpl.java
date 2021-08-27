package com.xy.blog.service.impl;

import com.xy.blog.entity.Link;
import com.xy.blog.exception.BlogException;
import com.xy.blog.mapper.LinkMapper;
import com.xy.blog.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 夕阳
 * @Description:
 */
@Service
public class LinkServiceImpl implements LinkService {
    @Autowired
    private LinkMapper linkMapper;

    /**
     * 添加链接
     * @param link
     */
    @Override
    public void saveLink(Link link) {
        linkMapper.saveLink(link);
    }

    /**
     * 删除链接
     * @param linkId
     */
    @Override
    public void deleteLink(Long linkId) {
        int result = linkMapper.deleteLink(linkId);
        if (result == 0){
            throw new BlogException("删除失败");
        }
    }

    /**
     * 修改链接
     * @param link
     */
    @Override
    public void updateLink(Link link) {
        int result = linkMapper.updateLink(link);
        if (result == 0){
            throw new BlogException("修改失败");
        }
    }

    /**
     * 根据id查询链接
     * @param linkId
     */
    @Override
    public Link getLinkById(Long linkId) {
        Link link = linkMapper.getLinkById(linkId);
        return link;
    }

    /**
     * 获取所有链接
     * @return
     */
    @Override
    public List<Link> getListLink() {
        List<Link> linkList = linkMapper.getListLink();
        return linkList;
    }
}
