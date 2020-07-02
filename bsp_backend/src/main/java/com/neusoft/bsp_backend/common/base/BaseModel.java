package com.neusoft.bsp_backend.common.base;

public class BaseModel {

    public Integer code = 200;

    public String message;

    @Override
    public String toString() {
        return "BaseModel{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
