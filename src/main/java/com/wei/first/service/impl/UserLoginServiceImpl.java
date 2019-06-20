package com.wei.first.service.impl;

import com.wei.first.bean.TestUserRegister;
import com.wei.first.mapper.TestUserRegisterMapper;
import com.wei.first.res.BaseResponse;
import com.wei.first.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    TestUserRegisterMapper userRegisterMapper;

    /**
     *  用户操作注册接口
     * @param userRegister
     */
    public BaseResponse UserRegister(TestUserRegister userRegister){
        BaseResponse baseResponse = new BaseResponse();
        int i = userRegisterMapper.insert(userRegister);
        if(i>0){
            return baseResponse;
        }else{
            baseResponse.setCode("9999");
            baseResponse.setMessage("新增失败");
            return baseResponse;
        }
    }
}
