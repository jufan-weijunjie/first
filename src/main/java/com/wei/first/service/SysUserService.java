package com.wei.first.service;

import com.wei.first.bean.SysUser;
import com.wei.first.bean.publicBean.BaseResponse;

/**
 * FileName：SysUserService
 * TODO
 *
 * @author 魏俊杰
 * @date 11:02 2019/4/8
 */
public interface SysUserService {
    public void addUser();
    public BaseResponse userLogin(SysUser sysUser);
}
