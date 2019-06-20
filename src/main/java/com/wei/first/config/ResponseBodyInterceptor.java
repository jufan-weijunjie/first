package com.wei.first.config;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * FileName：ResponseBodyInterceptor
 *
 * @author 魏俊杰
 * @date 18:45 2019/5/28
 */
@ControllerAdvice
public class ResponseBodyInterceptor implements ResponseBodyAdvice<Object> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     *
     * @param returnType returnType
     * @param converterType converterType
     * @return
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return returnType.hasMethodAnnotation(ResponseBody.class);
    }

    /**
     * 自定义输出responseBody返回参数
     * @param body body
     * @param returnType returnType
     * @param selectedContentType selectedContentType
     * @param selectedConverterType selectedConverterType
     * @param request request
     * @param response response
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        logger.info(returnType.getMethod().toString()+"返回参数：{}",JSONObject.toJSONString(body));
        return body;
    }
}
