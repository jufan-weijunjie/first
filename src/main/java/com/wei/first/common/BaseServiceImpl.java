package com.wei.first.common;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.util.List;

/**
 * FileName：BaseServiceImpl
 *
 * @author 魏俊杰
 * @date 16:43 2019/6/13
 */
public class BaseServiceImpl<T,PK extends Serializable,I extends BaseMapper> implements BaseService<T,PK> {

    @Autowired
    private I mapper;

    @Override
    public int insert(T bean) {
        return mapper.insert(bean);
    }

    @Override
    public int update(T bean) {
        return mapper.updateByPrimaryKey(bean);
    }

    @Override
    public int insertByBatch(List<T> entityList){
        return mapper.insertByBatch(entityList);
    }

    @Override
    public T selectByEntity(T entity){


        return (T)mapper.selectByEntity(entity);
    };


    private boolean checkEntityEmpty(T entity){
        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field:fields){
            String name = field.getName();
            AnnotatedType annotatedType = field.getAnnotatedType();

        }
        return false;
    }

}
