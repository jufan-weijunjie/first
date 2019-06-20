package com.wei.first.config.exception;

import com.wei.first.bean.publicBean.ResCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * FileName：MyException
 *
 * @author 魏俊杰
 * @date 17:38 2019/5/30
 */
@ControllerAdvice
public class MyExceptionHandlerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public HashMap<String,Object> exceptionHandler(Exception e){
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("code",ResCode.ERROR.getCode());
        hashMap.put("msg",e.getMessage());
//        BaseResponse baseResponse = new BaseResponse();
//        baseResponse.setCode(ResCode.ERROR.getCode());
//        baseResponse.setMessage(e.getMessage());
        return hashMap;
    }

}
