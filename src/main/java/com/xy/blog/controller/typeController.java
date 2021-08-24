package com.xy.blog.controller;

import com.xy.blog.entity.Type;
import com.xy.blog.enums.ResultEnum;
import com.xy.blog.service.TypeService;
import com.xy.blog.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 夕阳
 * @Description:
 */
@RestController
@RequestMapping("/type")
public class typeController {

    @Autowired
    private TypeService typeService;

    /**
     * 添加
     * @param type
     * @return
     */
    @RequestMapping(value = "/saveType",method = RequestMethod.POST)
    public ResultUtils<?> save(@RequestBody Type type){
        typeService.saveType(type);
        return new ResultUtils<>("保存成功");
    }

    /**
     * 根据id查询类型
     * @param typeId
     * @return
     */
    @RequestMapping(value = "/getTypeById/{typeId}",method = RequestMethod.GET)
    public ResultUtils<?> getTypeById(@PathVariable Long typeId){
        Type type = typeService.getTypeById(typeId);
        return new ResultUtils<>(type);
    }

    /**
     * 修改类型
     * @param type
     * @return
     */
    @RequestMapping(value = "/updateType",method = RequestMethod.POST)
    public ResultUtils<?> updateType(@RequestBody Type type){
        typeService.updateType(type);
        return new ResultUtils<>("修改成功");
    }

    /**
     * 删除类型
     * @param typeId
     * @return
     */
    @RequestMapping(value = "/deleteType/{typeId}",method = RequestMethod.DELETE)
    public ResultUtils<?> deleteType(@PathVariable Long typeId){
        typeService.deleteType(typeId);
        return new ResultUtils<>("删除成功");
    }


    /**
     * 查询所有类型（数据不多，故不采取分页功能）
     * @return
     */
    @RequestMapping(value = "/getListType",method = RequestMethod.GET)
    public ResultUtils<?> getListType(){
        List<Type> typeList = typeService.getListType();
        return new ResultUtils<>(typeList);
    }
}
