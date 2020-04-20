package com.hb.st.sswt.common;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * 公用返回数据模型
 *
 * @author Mr.huang
 * @since 2020/4/20 16:04
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseData<T> implements Serializable {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 4226532525009161450L;
    /**
     * 返回码
     */
    private int code;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 总条数
     */
    private Integer count;
    /**
     * 业务数据
     */
    private T data;

    public ResponseData(int code, String msg) {
        this(code, msg, null, null);
    }

    public ResponseData(int code, String msg, T data) {
        this(code, msg, null, data);
    }

    public ResponseData(int code, String msg, Integer count, T data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

}
