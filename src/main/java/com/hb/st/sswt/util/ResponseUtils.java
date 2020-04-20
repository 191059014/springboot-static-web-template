package com.hb.st.sswt.util;

import com.hb.st.sswt.common.ResponseData;
import com.hb.st.sswt.enums.ResponseEnum;

/**
 * 针对ResponseData的封装
 *
 * @author Mr.huang
 * @since 2020/4/20 16:18
 */
public class ResponseUtils {

    /**
     * 生成ResponseData
     *
     * @param responseEnum 返回码枚举对象
     * @param <T>          数据类型
     * @return 完整返回对象
     */
    public static <T> ResponseData<T> generateResponseData(ResponseEnum responseEnum) {
        return new ResponseData<>(responseEnum.getCode(), responseEnum.getMsg(), null, null);
    }

    /**
     * 生成ResponseData
     *
     * @param code 返回码
     * @param msg  返回信息
     * @param <T>  数据类型
     * @return 完整返回对象
     */
    public static <T> ResponseData<T> generateResponseData(int code, String msg) {
        return new ResponseData<>(code, msg, null, null);
    }

    /**
     * 生成ResponseData
     *
     * @param responseEnum 返回码枚举对象
     * @param data         业务数据
     * @param <T>          数据类型
     * @return 完整返回对象
     */
    public static <T> ResponseData<T> generateResponseData(ResponseEnum responseEnum, T data) {
        return new ResponseData<>(responseEnum.getCode(), responseEnum.getMsg(), null, data);
    }

    /**
     * 生成ResponseData
     *
     * @param code 返回码
     * @param msg  返回信息
     * @param data 业务数据
     * @param <T>  数据类型
     * @return 完整返回对象
     */
    public static <T> ResponseData<T> generateResponseData(int code, String msg, T data) {
        return new ResponseData<>(code, msg, null, data);
    }

    /**
     * 生成ResponseData
     *
     * @param responseEnum 返回码枚举对象
     * @param count        总条数
     * @param data         业务数据
     * @param <T>          数据类型
     * @return 完整返回对象
     */
    public static <T> ResponseData<T> generateResponseData(ResponseEnum responseEnum, int count, T data) {
        return new ResponseData<>(responseEnum.getCode(), responseEnum.getMsg(), count, data);
    }

    /**
     * 生成ResponseData
     *
     * @param code  返回码
     * @param msg   返回信息
     * @param count 总条数
     * @param data  业务数据
     * @param <T>   数据类型
     * @return 完整返回对象
     */
    public static <T> ResponseData<T> generateResponseData(int code, String msg, Integer count, T data) {
        return new ResponseData<>(code, msg, count, data);
    }

}
