package com.wei.first.mapper;

import com.wei.first.bean.SysUserCode;
import com.wei.first.bean.SysUserCodeQuery;
import com.wei.first.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface SysUserCodeMapper extends BaseMapper<SysUserCode,Integer> {
}