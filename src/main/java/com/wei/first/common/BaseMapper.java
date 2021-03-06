package com.wei.first.common;

import java.io.Serializable;
import java.util.List;

/**
 * FileName：BaseMapper
 *
 * @author 魏俊杰
 * @date 16:46 2019/6/13
 */
public interface BaseMapper<T,PK extends Serializable>{

    int deleteByPrimaryKey(PK id);

    int insert(T entity);

    int insertSelective(T entity);

    T selectByPrimaryKey(PK id);

    int updateByPrimaryKeySelective(T entity);

    int updateByPrimaryKey(T entity);

    int insertByBatch(List<T> entityList);

    T selectByEntity(T entity);

    /*------------------page分页------------------------------------*/
//    int pageSelectCountByBean(T bean);

//    List<T> pageSelectListByBean(T bean);
}
