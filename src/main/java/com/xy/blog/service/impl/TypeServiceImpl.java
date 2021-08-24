package com.xy.blog.service.impl;

import com.xy.blog.entity.Type;
import com.xy.blog.enums.ResultEnum;
import com.xy.blog.exception.BlogException;
import com.xy.blog.mapper.TypeMapper;
import com.xy.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 夕阳
 * @Description:
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;


    /**
     * 添加
     * @param type
     */
    @Override
    public void saveType(Type type) {

        typeMapper.saveType(type);

    }

    /**
     * 根据id查询类型
     * @param typeId
     * @return
     */
    @Override
    public Type getTypeById(Long typeId) {
        Type type = typeMapper.getTypeById(typeId);
        if (type == null){
            throw  new BlogException("查询类型信息失败", ResultEnum.ERROR.getCode());
        }
        return type;
    }

    /**
     * 修改类型
     * @param type
     */
    @Override
    public void updateType(Type type) {
        int result = typeMapper.updateType(type);
        if (result == 0){
            throw new BlogException("修改失败",ResultEnum.ERROR.getCode());
        }
    }

    /**
     * 删除类型
     * @param typeId
     */
    @Override
    public void deleteType(Long typeId) {
        int result = typeMapper.deleteType(typeId);
        if (result == 0){
            throw new BlogException("删除失败",ResultEnum.ERROR.getCode());
        }
    }

    /**
     * 查询所有类型
     * @return
     */
    @Override
    public List<Type> getListType() {
        List<Type> typeList = typeMapper.getListType();
        return typeList;
    }
}
