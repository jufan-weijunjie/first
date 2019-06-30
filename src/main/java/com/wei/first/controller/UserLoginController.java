package com.wei.first.controller;

import com.alibaba.fastjson.JSONObject;
import com.wei.first.bean.SysUser;
import com.wei.first.bean.TestUserRegister;
import com.wei.first.bean.publicBean.ResCode;
import com.wei.first.res.BaseResponse;
import com.wei.first.service.UserLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping
public class UserLoginController {

    @Autowired
    UserLoginService userLoginService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/registerSubmit")
    public Object registerSubmit(TestUserRegister register){
        return userLoginService.UserRegister(register);
    }

    @RequestMapping("/showUserInfo")
    public ModelAndView showUserInfo(){
        TestUserRegister register = new TestUserRegister();
        register.setUserCode("2323424");
        register.setUserName("hahahahh");
        register.setUserPwd("123123123");
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", register);
        mv.addObject("pwd", register);
        mv.setViewName("UserInfo");
        return mv;
    }

    /*@ResponseBody
    @RequestMapping("/aaaa")
    public Object aaaa(){
        BaseResponse baseResponse = new BaseResponse();
        return baseResponse;
    }*/

    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "/aaa/bbb" , method = RequestMethod.POST,produces = "application/json; charset=UTF-8" )
    public Object sysUserLogin(@RequestBody SysUser sysUser, HttpServletRequest request, HttpServletResponse response){
//        System.out.println("*****登录请求参数：{}"+JSONObject.toJSONString(sysUser));
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(ResCode.ERROR.getCode());
        baseResponse.setMessage(ResCode.ERROR.getMsg());
        return baseResponse;
//        return sysUserService.userLogin(sysUser);
    }

}
