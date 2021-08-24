package com.xy.blog.mapper;

import com.xy.blog.entity.Type;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 夕阳
 * @Description:
 */
@Component
public interface TypeMapper {

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
     * @return
     */
    int updateType(Type type);

    /**
     * 删除类型
     * @param typeId
     * @return
     */
    int deleteType(Long typeId);

    /**
     * 查询所有分类
     * @return
     */
    List<Type> getListType();
}
