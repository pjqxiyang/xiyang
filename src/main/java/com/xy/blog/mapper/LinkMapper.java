package com.xy.blog.mapper;

import com.xy.blog.entity.Link;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 夕阳
 * @Description:
 */
@Component
public interface LinkMapper {

    /**
     * 添加链接
     * @param link
     */
    void saveLink(Link link);

    /**
     * 删除链接
     * @param linkId
     * @return
     */
    int deleteLink(Long linkId);

    /**
     * 修改链接
     * @param link
     * @return
     */
    int updateLink(Link link);

    /**
     * 根据id查询链接
     * @param linkId
     * @return
     */
    Link getLinkById(Long linkId);

    /**
     * 获取所有链接
     * @return
     */
    List<Link> getListLink();
}
