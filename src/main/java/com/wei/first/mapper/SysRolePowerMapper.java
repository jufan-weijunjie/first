package com.wei.first.mapper;

import com.wei.first.bean.SysRolePower;

public interface SysRolePowerMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(SysRolePower record);

    int insertSelective(SysRolePower record);

    SysRolePower selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRolePower record);

    int updateByPrimaryKey(SysRolePower record);
}