package com.wei.first.common;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * FileName：BaseServiceImpl
 *
 * @author 魏俊杰
 * @date 16:43 2019/6/13
 */
public class BaseServiceImpl<T,PK extends Serializable> implements BaseService<T,PK> {

    @Autowired
    private BaseMapper baseMapper;

    @Override
    public int insert(PK bean) {
        return baseMapper.insert(bean);
    }

    @Override
    public int update(PK bean) {
        return baseMapper.updateByPrimaryKey(bean);
    }
}
