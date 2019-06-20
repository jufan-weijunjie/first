package com.wei.first.bean.publicBean;

import java.io.Serializable;

/**
 * FileName：BaseResponse
 *
 * @author 魏俊杰
 * @date 16:05 2019/5/26
 */
public class BaseResponse implements Serializable {

    /**
     * @Fields serialVersionUID : 序列化版本号
     */
    private static final long serialVersionUID = 5234160315565008675L;

    private String code;

    private String message;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BaseResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }
    public BaseResponse(String code, String message,Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public BaseResponse() {
        this.code = ResCode.SUCCESS.getCode();
        this.message = ResCode.SUCCESS.getMsg();
    }
}
