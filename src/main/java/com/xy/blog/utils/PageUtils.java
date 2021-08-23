package com.xy.blog.utils;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 夕阳
 * @Description: 分页查询
 */
@Data
public class PageUtils<T> implements Serializable {

    private static final long serialVersionUID = -5379538798236724996L;

    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 当前页的最大显示数据量
     */
    private Integer pageSize;

    /**
     * 总条数
     */
    private Integer totalCount;

    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 分页索引
     */
    private Integer index;

    /**
     * 返回结果
     */
    private List<T> list;

    /**
     * 查询条件
     */
    private Map<String,Object> params = new HashMap<>(8);

    /**
     * 排序列
     */
    private String sortColumn;

    /**
     * 排序方式
     */
    private String sortMethod = "asc";

    public Integer getCurrentPage(){
        if (this.currentPage == null){
            return 1;
        }
        return this.currentPage;
    }

    public Integer getPageSize(){
        if (this.pageSize == null){
            return 20;
        }
        return this.pageSize;
    }

    public Integer getIndex(){
        return pageSize * (currentPage -1);
    }

    public void setTotalCount(Integer totalCount){
        this.totalCount = totalCount;
        this.totalPage = (int)Math.ceil(totalCount * 1.0 / getPageSize()); // 向上取整
    }


}
