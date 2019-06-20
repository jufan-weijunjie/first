package com.wei.first.config.interceptor;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * FileName：MyInterceptor
 *
 * @author 魏俊杰
 * @date 11:59 2019/5/16
 */
public class MyInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * preHandle在业务处理器处理请求之前被调用。预处理，可以进行编码、安全控制等处理
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求地址的完整请求URL
        StringBuffer requestURL = request.getRequestURL();
        logger.info("****客户端请求完整URL:{}",requestURL);
        String requestURI = request.getRequestURI();
//        String token = request.getHeader("token");
//        System.err.println("**********"+token);
        logger.info(requestURI+"请求参数：{}",JSONObject.toJSONString(request.getParameterMap()));
        /*if(StringUtils.isNotBlank(requestURI) && "/login".equals(requestURI)){
            return true;
        }else{
            return false;
        }*/
        return true;
//        String queryString = request.getQueryString();
//        System.out.println(queryString);
//        String pathInfo = request.getPathInfo();
//        System.out.println(pathInfo);
//        String remoteUser = request.getRemoteUser();
//        String remoteAddr = request.getRemoteAddr();
//        String remoteHost = request.getRemoteHost();
//        int remotePort = request.getRemotePort();
//        System.out.println("--"+remoteUser+"--"+remoteAddr+"--"+remoteHost+"--"+remotePort);
//        //response
//        //输出错误信息到浏览器上
////        response.getWriter().write("aaaaERROR");
////        return false;
//        //重定向
//        response.sendRedirect("/login");
//        return false;
    }

    /**
     * postHandle在业务处理器处理请求执行完成后，生成视图之前执行。后处理（调用了Service并返回ModelAndView，但未进行页面渲染），有机会修改ModelAndView；
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
//        System.out.println("-=-=-=-=-=-="+response.);
    }

    /**
     * afterCompletion在DispatcherServlet完全处理完请求后被调用，可用于清理资源等。返回处理（已经渲染了页面），可以根据ex是否为null判断是否发生了异常，进行日志记录；
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }

    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    }
}
