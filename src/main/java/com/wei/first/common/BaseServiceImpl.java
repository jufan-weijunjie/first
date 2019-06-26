package com.wei.first.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(this.getClass());

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
        if(checkEntityEmpty(entity)){
            return (T)mapper.selectByEntity(entity);
        }else{
            return null;
        }
    };

    /**
     *  验证对象的属性值是否为null
     * @param entity entity
     * @return
     */
    private boolean checkEntityEmpty(T entity){
        boolean boo = false;
        try {
            Field[] fields = entity.getClass().getDeclaredFields();
            if(null == fields || fields.length == 0){
                return boo;
            }
            for (Field field:fields){
                //设置属性读取权限（可以读取private值）
                field.setAccessible(true);
                String name = field.getName();
                if(name.equals("serialVersionUID")){
                    continue;
                }
                AnnotatedType annotatedType = field.getAnnotatedType();
                String typeName = annotatedType.getType().getTypeName();
                Object o = field.get(entity);
                if(null == o){
                    logger.info("{}属性值为null",name);
                }else{
                    logger.info("{}有属性值{}",name,typeName);
                    boo = true;
                }
            }
            return boo;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public T selectByPrimaryKey(PK id){
        return (T)mapper.selectByPrimaryKey(id);
    }

}
