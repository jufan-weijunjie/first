package com.wei.first.service;

import com.wei.first.bean.GetPhoto;
import com.wei.first.common.BaseService;
import com.wei.first.res.BaseResponse;

import java.util.List;

/**
 * FileName：PhotoService
 *
 * @author 魏俊杰
 * @date 15:45 2019/4/25
 */
public interface PhotoService extends BaseService<GetPhoto,Integer> {

    public BaseResponse getPhotoTitleList(Integer pageIndex, Integer pageSize);

    public BaseResponse getPhotoListByCode(String photoCode);



}
