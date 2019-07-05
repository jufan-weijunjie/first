package com.wei.first.config.shiro;

import com.wei.first.mapper.SysUserCodeMapper;
import com.wei.first.mapper.SysUserMapper;
import com.wei.first.service.UserCodeService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * FileName：ShiroRealm
 *
 * @author 魏俊杰
 * @date 11:50 2019/7/5
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserCodeService userCodeService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //1.先获取到用户名
        String userName = (String) principalCollection.getPrimaryPrincipal();
        //2.从数据库或者缓存中获取角色数据
//        Set<String> roles = getRolesByUserName(userName);
        //3.从数据库或缓存中获取权限数据
//        Set<String> permissions = getPermissionsByUserName(userName);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        simpleAuthorizationInfo.setStringPermissions(permissions);
//        simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo;
//        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
