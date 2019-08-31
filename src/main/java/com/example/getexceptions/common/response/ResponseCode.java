package com.example.getexceptions.common.response;

/**
 * Created by 邓锦辉
 */
public enum ResponseCode {

    SUCCESS(100, "SUCCESS"),
    ERROR(500, "ERROR"),
    URL_ERROR(404, "路径错误"),


    //自定义异常
    NEED_LOGIN(10, "NEED_LOGIN"),
    ILLEGAL_ARGUMENT(2, "ILLEGAL_ARGUMENT"),

    //运行时异常
    NULL_EXCEPTION(20001, "空值问题"),
    ARITH_EXCEPTION(20002, "算数问题"),
    COMMON_ERROR(99999, "未知错误");

    private final int code;
    private final String desc;


    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
