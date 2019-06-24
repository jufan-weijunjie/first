package com.wei.first.mapper;

import com.wei.first.bean.SysUserRole;

public interface SysUserRoleMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);
}