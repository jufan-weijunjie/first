package com.wei.first;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * FileName：springBoot项目打war包 修改启动类，继承 SpringBootServletInitializer 并重写 configure 方法
 *
 * @author 魏俊杰
 * @date 10:26 2019/7/4
 */
public class SpringBootStartApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FirstApplication.class);
    }
}
