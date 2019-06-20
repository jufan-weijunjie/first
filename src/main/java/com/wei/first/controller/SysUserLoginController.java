package com.wei.first.controller;

import com.alibaba.fastjson.JSONObject;
import com.wei.first.bean.SysUser;
import com.wei.first.mapper.SysUserMapper;
import com.wei.first.service.SysUserService;
import com.wei.first.utils.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * FileName：SysUserLoginController
 *
 * @author 魏俊杰
 * @date 16:19 2019/5/24
 */
@RestController
@Controller
@RequestMapping("/login/")
public class SysUserLoginController {

    @Autowired
    private SysUserService sysUserService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "sysUserLogin" , method = RequestMethod.POST,produces = "application/json; charset=UTF-8" )
    public Object sysUserLogin(@RequestBody SysUser sysUser, HttpServletRequest request, HttpServletResponse response){
        logger.info("*****登录请求参数：{}",JSONObject.toJSONString(sysUser));
        return sysUserService.userLogin(sysUser);
    }
}
