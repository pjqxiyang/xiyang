package com.xy.blog.controller;

import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlShowColumnOutpuVisitor;
import com.xy.blog.entity.Link;
import com.xy.blog.service.LinkService;
import com.xy.blog.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 夕阳
 * @Description:
 */
@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    /**
     * 添加链接
     * @param link
     * @return
     */
    @RequestMapping(value = "/saveLink",method = RequestMethod.POST)
    public ResultUtils<?> saveLink(@RequestBody Link link){
        linkService.saveLink(link);
        return new ResultUtils<>();
    }

    /**
     * 删除链接
     * @param linkId
     * @return
     */
    @RequestMapping(value = "/deleteLink/{linkId}",method = RequestMethod.DELETE)
    public ResultUtils<?> deleteLink(@PathVariable Long linkId){
        linkService.deleteLink(linkId);
        return new ResultUtils<>();
    }

    /**
     * 修改链接
     * @param link
     * @return
     */
    @RequestMapping(value = "updateLink",method = RequestMethod.POST)
    public ResultUtils<?> updateLink(@RequestBody Link link){
        linkService.updateLink(link);
        return new ResultUtils<>();
    }

    /**
     * 根据id查询链接
     * @param linkId
     * @return
     */
    @RequestMapping(value = "/getLinkById/{linkId}",method = RequestMethod.GET)
    public ResultUtils<?> getLinkById(@PathVariable Long linkId){
        Link link = linkService.getLinkById(linkId);
        return new ResultUtils<>(link);
    }

    /**
     * 获取所有链接
     * @return
     */
    @RequestMapping(value = "/getListLink",method = RequestMethod.GET)
    public ResultUtils<?> getListLink(){
        List<Link> linkList = linkService.getListLink();
        return new ResultUtils<>(linkList);
    }
}
