package com.hb.st.sswt.enums;

/**
 * 返回码
 *
 * @author Mr.huang
 * @since 2020/4/20 16:20
 */
public enum ResponseEnum {

    SUCCESS(10000, "成功"),
    ERROR(99999, "系统异常，请稍后再试！"),
    ;

    /**
     * 返回码
     */
    private int code;
    /**
     * 返回信息
     */
    private String msg;

    ResponseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
