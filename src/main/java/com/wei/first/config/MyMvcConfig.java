package com.wei.first.config;


import com.wei.first.config.interceptor.MyInterceptor;
import com.wei.first.config.listener.MyHttpSessionListener;
import com.wei.first.config.listener.MyWebListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * mvc配置
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    /*资源处理器*/
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/view").addResourceLocations("/WEB-INF/" + "/view/");
    }

    /**
     *  addPathPatterns添加拦截器 excludePathPatterns过滤拦截器
     * @param registry
     */
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login/**","/resources/**");
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public ServletListenerRegistrationBean listenerRegist() {
        ServletListenerRegistrationBean srb = new ServletListenerRegistrationBean();
        srb.setListener(new MyHttpSessionListener());
        System.out.println("listener");
        return srb;
    }
}


//---------------------
//    作者：ApacheCrazyFan
//    来源：CSDN
//    原文：https://blog.csdn.net/apathecrazyfan/article/details/79638731
//    版权声明：本文为博主原创文章，转载请附上博文链接！