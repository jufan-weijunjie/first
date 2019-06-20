package com.wei.first.config.logConfig;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * FileName：LogConfig
 *   -- @Component实例化到spring  @Aspect面向切面编程   @Pointcut()定义切面位置
 * @author 魏俊杰
 * @date 14:52 2019/5/31
 */

@Component
@Aspect
public class LogConfig {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //定义切面位置（切点）-- 正常请求，正常返回
    @Pointcut(value = "execution(* com.wei.first.controller.*.*(..))")
    public void normalPoint(){
    }

    /**
     * 定义切面方式(方位信息) @After @Before
     * @return
     */
    @Around(value = "normalPoint()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        //获取joinPoint中的参数列表
        Object[] args = joinPoint.getArgs();
        if(null != args || args.length >0){
            //过滤请求参数中的request&response,否则直接转json可能会报异常 It is illegal to call this method if the current request is not in asynchronous mode (i.e. isAsyncSt
            List<Object> collect = Arrays.stream(args).filter(arg -> (!(arg instanceof HttpServletRequest) &&
                    !(arg instanceof HttpServletResponse))).collect(Collectors.toList());
            String argStr = JSONObject.toJSONString(collect);
            //得到请求方法名等信息
            logger.info("请求方法{}，参数{}",joinPoint.toShortString(),JSONObject.toJSONString(argStr));
            //获取request信息
            HttpServletRequest request;
            for(int i = 0;i<args.length;i++){
                if(args[i] instanceof HttpServletRequest){
                    request = (HttpServletRequest)args[i];
                }
            }

        }

        Object proceed = joinPoint.proceed();
        if(null!= proceed){
            logger.info("response:{}",proceed);
        }
        return proceed;
    }


}
