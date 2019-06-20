package com.wei.first.config.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * FileName：MyFilter
 * 只有配置该路径的请求会经过该filter
 * @author 魏俊杰
 * @date 15:57 2019/5/17
 */
@WebFilter(urlPatterns = "/login*", filterName = "MyFilter")
public class MyFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("-*-*-*-*-*-执行Filter-*-*-*-*-*-");
        servletRequest.setAttribute("","");
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("-*-*-*-*-*-初始化Filter-*-*-*-*-*-");
    }

    @Override
    public void destroy() {
        logger.info("-*-*-*-*-*-Filter结束-*-*-*-*-*-");
    }

}
