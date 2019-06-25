package com.wei.first.common;

import java.io.Serializable;
import java.util.List;

/**
 * FileName：BaseService
 *
 * @author 魏俊杰
 * @date 16:44 2019/6/13
 */
public interface BaseService<T,PK extends Serializable> {

    public int insert(T bean);

    public int update(T bean);

    public int insertByBatch(List<T> entityList);

    public T selectByEntity(T entity);


}
