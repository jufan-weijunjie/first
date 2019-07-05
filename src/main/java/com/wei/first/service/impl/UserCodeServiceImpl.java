package com.wei.first.service.impl;

import com.wei.first.bean.SysUserCode;
import com.wei.first.common.BaseServiceImpl;
import com.wei.first.mapper.SysUserCodeMapper;
import com.wei.first.service.UserCodeService;
import org.springframework.stereotype.Service;

/**
 * FileName：UserCodeServiceImpl
 *
 * @author 魏俊杰
 * @date 14:29 2019/7/5
 */
@Service
public class UserCodeServiceImpl extends BaseServiceImpl<SysUserCode,Integer,SysUserCodeMapper> implements UserCodeService {
}
