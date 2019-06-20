package com.wei.first.config.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * FileName：MyWebListener
 * web监听
 * @author 魏俊杰
 * @date 16:58 2019/5/14
 */
@WebListener
public class MyWebListener implements ServletContextListener {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("***********spring容器启动**************");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("***********spring容器销毁**************");
    }
}
