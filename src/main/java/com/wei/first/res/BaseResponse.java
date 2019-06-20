package com.wei.first.res;

import java.io.Serializable;

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

    public BaseResponse() {
        this.code = "200";
        this.message = "SUCCESS";
    }
}
