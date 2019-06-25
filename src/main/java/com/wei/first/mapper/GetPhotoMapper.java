package com.wei.first.mapper;

import com.wei.first.bean.GetPhoto;
import com.wei.first.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface GetPhotoMapper extends BaseMapper<GetPhoto,Integer> {

}