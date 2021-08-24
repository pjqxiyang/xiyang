package com.xy.blog.service;

import com.xy.blog.entity.Type;

import java.util.List;

/**
 * @author 夕阳
 * @Description:
 */
public interface TypeService {

    /**
     * 添加
     * @param type
     */
    void saveType(Type type);

    /**
     * 根据id查询类型
     * @param typeId
     * @return
     */
    Type getTypeById(Long typeId);


    /**
     * 修改类型
     * @param type
     */
    void updateType(Type type);

    /**
     * 删除类型
     * @param typeId
     */
    void deleteType(Long typeId);

    /**
     * 查询所有类型
     * @return
     */
    List<Type> getListType();
}
