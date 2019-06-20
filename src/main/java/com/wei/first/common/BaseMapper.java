package com.wei.first.common;

import com.wei.first.bean.GetPhoto;

import java.io.Serializable;

/**
 * FileName：BaseMapper
 *
 * @author 魏俊杰
 * @date 16:46 2019/6/13
 */
public interface BaseMapper<T,PK extends Serializable> {

    int deleteByPrimaryKey(PK id);

    int insert(T entity);

    int insertSelective(T entity);

    GetPhoto selectByPrimaryKey(PK id);

    int updateByPrimaryKeySelective(T entity);

    int updateByPrimaryKey(T entity);
}
