package com.wei.first.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wei.first.bean.SysUser;
import com.wei.first.bean.SysUserCode;
import com.wei.first.bean.publicBean.BaseResponse;
import com.wei.first.bean.publicBean.ResCode;
import com.wei.first.mapper.SysUserCodeMapper;
import com.wei.first.mapper.SysUserMapper;
import com.wei.first.service.SysUserService;
import com.wei.first.utils.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * FileName：SysUserServiceImpl
 * TODO
 *
 * @author 魏俊杰
 * @date 11:02 2019/4/8
 */
@Service
public class SysUserServiceImpl implements SysUserService {

//    private static final Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);
    @Value("${jwt.id}")
    private String jwtId;

    @Value("${jwt.time}")
    private Long jwtTime;

    @Autowired
    SysUserMapper sysUserMapper;

    @Autowired
    SysUserCodeMapper sysUserCodeMapper;

    public void addUser(){
//        logger.info("*******开始添加数据信息*******");
//        SysUserCode sysUserCode = new SysUserCode();
//        sysUserCode.setUserName("2222");
//        sysUserCode.setUserPwd("3333");
//        sysUserCodeMapper.insert(sysUserCode);
        System.out.println(jwtId+"---"+jwtTime);
    }

    /**
     *  用户登录操作
     * @param sysUser sysUser
     * @return
     */
    public BaseResponse userLogin(SysUser sysUser){
        BaseResponse baseResponse = checkUserLogin(sysUser);
        if(ResCode.SUCCESS.getCode().equals(baseResponse.getCode())){
            //check success
            SysUser sysUser1 = sysUserMapper.selectByUserCode(sysUser.getUserCode());
            if(null == sysUser1 || null == sysUser1.getUserId()){
                baseResponse.setCode(ResCode.NO_USER.getCode());
                baseResponse.setMessage(ResCode.NO_USER.getMsg());
            }else{
                //账号验证通过，登录成功，返回jwt验证数据
                JwtUtils jwtUtils = new JwtUtils();
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code",sysUser1.getUserCode());
                jsonObject.put("id",sysUser1.getUserId());
                String jwt = jwtUtils.createJWT(jwtId, jsonObject.toJSONString(), jwtTime);
                baseResponse.setCode(ResCode.SUCCESS.getCode());
                baseResponse.setMessage("账号验证通过");
                JSONObject jsonObj = new JSONObject();
                jsonObj.put("token", jwt);
                baseResponse.setData(jsonObj);
            }
        }
        return baseResponse;
    }

    /**
     * 验证用户登录的参数是否合法
     * @param sysUser sysUser
     * @return
     */
    public BaseResponse checkUserLogin(SysUser sysUser){
        BaseResponse baseResponse = new BaseResponse();
        if(StringUtils.isBlank(sysUser.getUserCode()) || StringUtils.isBlank(sysUser.getPwd())){
            baseResponse.setCode(ResCode.ERROR.getCode());
            baseResponse.setMessage("账号或密码为空");
        }else{
            baseResponse.setCode(ResCode.SUCCESS.getCode());
            baseResponse.setMessage("账号验证通过");
        }
        return baseResponse;
    }
}
