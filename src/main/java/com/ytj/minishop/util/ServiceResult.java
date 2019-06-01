package com.ytj.minishop.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceResult<T> {
    private int code;
    private String message;
    private T data;

    public static ServiceResult success() {
        return new ServiceResult(0);
    }

    public static ServiceResult fail(String message) {
        return new ServiceResult(1, message);
    }

    public ServiceResult(){}

    public ServiceResult(int code) {
        this.code = code;
    }

    public ServiceResult(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
