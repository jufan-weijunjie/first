package com.wei.first.mapper;

import com.wei.first.bean.GetPhoto;
import com.wei.first.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface GetPhotoMapper extends BaseMapper<GetPhoto,Integer> {

    /*int deleteByPrimaryKey(Integer id);

    int insert(GetPhoto record);

    int insertSelective(GetPhoto record);

    GetPhoto selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GetPhoto record);

    int updateByPrimaryKey(GetPhoto record);*/
}