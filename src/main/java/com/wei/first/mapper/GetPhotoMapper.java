package com.wei.first.mapper;

import com.wei.first.bean.GetPhoto;
import com.wei.first.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GetPhotoMapper extends BaseMapper<GetPhoto,Integer> {

    public List<GetPhoto> getPhotoTitleList(@Param("pageIndex") int pageIndex,@Param("pageSize")int pageSize);

    int selectTitleCount();

    List<GetPhoto> getPhotoByPhotoCode(@Param("photoCode") String photoCode);
}