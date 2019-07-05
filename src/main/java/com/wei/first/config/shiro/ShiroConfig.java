package com.wei.first.config.shiro;

import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * FileName：ShiroConfig
 *
 * @author 魏俊杰
 * @date 11:39 2019/7/5
 */
@Configuration
public class ShiroConfig {

    /**
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     * @param securityManager
     * @return
     */
    @Bean(name = "shirFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        System.out.println("----***开始执行shiro的安全接口配置****------");
        //必须设置 SecurityManager,Shiro的核心安全接口
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //这里的/login是后台的接口名,非页面，如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        //这里的/index是后台的接口名,非页面,登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //未授权界面,该配置无效，并不会进行页面跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");
        //自定义拦截器限制并发人数,参考博客：
        // LinkedHashMap<String, Filter> filtersMap = new LinkedHashMap<>();
        // 限制同一帐号同时在线的个数
        // filtersMap.put("kickout", kickoutSessionControlFilter());
        // shiroFilterFactoryBean.setFilters(filtersMap);
        // 配置访问权限 必须是LinkedHashMap，因为它必须保证有序
        // 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 一定要注意顺序,否则就不好使了
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        //配置不登录可以访问的资源，anon 表示资源都可以匿名访问
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/", "anon");
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        filterChainDefinitionMap.put("/druid/**", "anon");
        //logout是shiro提供的过滤器
        filterChainDefinitionMap.put("/logout", "logout");
        //此时访问/userInfo/del需要del权限,在自定义Realm中为用户授权。
        // filterChainDefinitionMap.put("/userInfo/del", "perms[\"userInfo:del\"]");
        // 其他资源都需要认证  authc 表示需要认证才能进行访问
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }
    @Bean(name="securityManager")
    public SecurityManager securityManager(@Qualifier("shiroRealm") ShiroRealm shiroRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //设置自定义realm.
        securityManager.setRealm(shiroRealm);
        //配置记住我 参考博客：
        // securityManager.setRememberMeManager(rememberMeManager());
        // 配置 redis缓存管理器 参考博客：
        // securityManager.setCacheManager(getEhCacheManager());
        // 配置自定义session管理，使用redis 参考博客：
        // securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

        @Bean(name = "lifecycleBeanPostProcessor")
        public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
            return new LifecycleBeanPostProcessor();
        }

        /**
         * 身份认证realm; (这个需要自己写，账号密码校验；权限等)
         */
        @Bean
        public ShiroRealm shiroRealm(){
            ShiroRealm shiroRealm = new ShiroRealm();
            return shiroRealm;
        }
        //模板引擎
        /*@Bean
        public ShiroDialect shiroDialect() {
            return new ShiroDialect();
        }*/
}
