package com.hh.recipe.utils;

//状态码的枚举类
public enum ResultCodeEnum {
    //枚举
    SUCCESS(200, "success"),
    USERNAME_ERROR(501, "usernameError"),
    PASSWORD_ERROR(503, "passwordError"),
    NOTLOGIN(504, "notLogin"),
    USERNAME_USED(505, "userNameUsed");
    private Integer code;
    private String message;

    //带参的构造函数
    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    //get方法
    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
