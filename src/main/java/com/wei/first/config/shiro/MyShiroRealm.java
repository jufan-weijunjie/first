package com.wei.first.config.shiro;

import com.wei.first.bean.SysUserRole;
import com.wei.first.service.UserRoleService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * FileName：MyShiroRealm
 *
 * @author 魏俊杰
 * @date 17:24 2019/6/20
 */
public class MyShiroRealm extends AuthorizingRealm{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRoleService userRoleService;


    Map<String, String> userMap = new HashMap<String, String>(16);
    {
        userMap.put("xiehuaxin","123456");
        super.setName("customReal");//自定义
    }
    /**
     * 用来做授权(就是checkRole，checkPermission时用到的)验证权限，验证身份
     * @param principalCollection principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //1.先获取到用户名
        String userName = (String) principalCollection.getPrimaryPrincipal();
        //2.从数据库或者缓存中获取角色数据
        Set<String> roles = getRolesByUserName(userName);
        //3.从数据库或缓存中获取权限数据
        Set<String> permissions = getPermissionsByUserName(userName);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissions);
        simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo;
    }

    /**
     * 从数据库或缓存中获取权限数据(这里模拟数据库查询)
     * @param userName userName
     * @return
     */
    private Set<String> getPermissionsByUserName(String userName) {
        Set<String> sets = new HashSet<String>();
        sets.add("user:delete");
        sets.add("user:add");
        return sets;
    }

    /**
     * 通过用户名获取到角色数据（这里为了简单点就不真的去查询数据库了，仅模拟数据库查询）
     * @param userName userName
     * @return
     */
    private Set<String> getRolesByUserName(String userName) {
        Set<String> sets = new HashSet<String>();
        sets.add("admin");
        sets.add("user");
        return sets;
    }

    /**
     * 用来做认证（就是login时用到的）
     * @param authenticationToken           主体subject传过来的验证信息
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.先通过主体传过来的验证信息获取用户名
        String userName = (String) authenticationToken.getPrincipal();
        //2.通过用户名去数据库中获取凭证
        String password = getPasswordByUserName(userName);
        if(password == null) {
            return null;
        }
        //查询到用户，则返回AuthenticationInfo对象
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo("xiehuaxin",password,"customRealm");
        return authenticationInfo;
    }

    private String getPasswordByUserName(String userName) {
        //这里我就不写查询数据库了，就模拟去查数据库
        return userMap.get(userName);
    }

    private String getUserRoleByUserName(String userName){
        SysUserRole sysUserRole = new SysUserRole();
        userRoleService.selectByEntity(sysUserRole);
        return "";
    }
}
