package com.wei.first.mapper;

import com.wei.first.bean.SysUserCode;
import com.wei.first.bean.SysUserCodeQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface SysUserCodeMapper {
    long countByExample(SysUserCodeQuery example);

    int deleteByExample(SysUserCodeQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysUserCode record);

    int insertSelective(SysUserCode record);

    List<SysUserCode> selectByExample(SysUserCodeQuery example);

    SysUserCode selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysUserCode record, @Param("example") SysUserCodeQuery example);

    int updateByExample(@Param("record") SysUserCode record, @Param("example") SysUserCodeQuery example);

    int updateByPrimaryKeySelective(SysUserCode record);

    int updateByPrimaryKey(SysUserCode record);
}