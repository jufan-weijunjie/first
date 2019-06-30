package com.wei.first.service.impl;

import com.wei.first.bean.GetPhoto;
import com.wei.first.bean.publicBean.ResCode;
import com.wei.first.common.BaseServiceImpl;
import com.wei.first.mapper.GetPhotoMapper;
import com.wei.first.res.BaseResponse;
import com.wei.first.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * FileName：PhotoServiceImpl
 *
 * @author 魏俊杰
 * @date 15:45 2019/4/25
 */
@Service
public class PhotoServiceImpl extends BaseServiceImpl<GetPhoto,Integer,GetPhotoMapper> implements PhotoService {

    @Autowired
    GetPhotoMapper getPhotoMapper;

    /**
     * 功能描述: <br>
     * 〈获取当前所有的类型名称〉
     * @Param: []
     * @Return: java.util.List<com.wei.first.bean.GetPhoto>
     * @Author: weijunjie
     * @Date: 2019/6/30 15:18
     */
    @Override
    public BaseResponse getPhotoTitleList(Integer pageIndex,Integer pageSize){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(ResCode.SUCCESS.getCode());
        baseResponse.setMessage(ResCode.SUCCESS.getMsg());
        //获取count计算页数
        try {
            int count = getPhotoMapper.selectTitleCount();
            if(pageIndex <=1)pageIndex = 1;
            if((count - pageIndex*pageSize)<pageSize)pageIndex = pageIndex-1;
            List<GetPhoto> photoList =  getPhotoMapper.getPhotoTitleList(pageIndex,pageSize);
            baseResponse.setData(photoList);
        }catch (Exception e){
            e.printStackTrace();
            baseResponse.setCode(ResCode.ERROR.getCode());
            baseResponse.setMessage(ResCode.ERROR.getMsg());
        }

        return baseResponse;
    }

    public BaseResponse getPhotoListByCode(String photoCode){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(ResCode.SUCCESS.getCode());
        baseResponse.setMessage(ResCode.SUCCESS.getMsg());
        List<GetPhoto> photoByPhotoCode = getPhotoMapper.getPhotoByPhotoCode(photoCode);
        baseResponse.setData(photoByPhotoCode);
        return baseResponse;

    }

}
