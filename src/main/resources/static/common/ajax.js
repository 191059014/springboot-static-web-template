import * as EnvConfig from "../config/env_config.js";
import {STATUS} from "./constant.js";

/**
 * 获取完整请求路径
 * @param url 请求路径
 * @returns 完整url路径
 */
const getFullRequestUrl = (url) => {
    let baseUrl = EnvConfig.getBaseRequestUrl();
    return baseUrl + url;
};

/**
 * get请求
 * @param url 请求地址
 */
export const get = (url) => {
    let fullRequestUrl = getFullRequestUrl(url);
    return new Promise((resolve, reject) => {
        try {
            $.ajax({
                type: "get",
                url: fullRequestUrl,
                success: function (res) {
                    if (STATUS.SUCCESS.code === res.code) {
                        resolve(res);
                    } else {
                        reject(res);
                    }
                }
            });
        } catch (e) {
            console.error(e);
            Alert(STATUS.ERROR.msg);
        }
    });
};

/**
 * post请求
 * @param url 请求地址
 * @param jsonData 请求体
 */
export const post = (url, jsonData) => {
    let fullRequestUrl = getFullRequestUrl(url);
    return new Promise((resolve, reject) => {
        try {
            $.ajax({
                type: "get",
                url: fullRequestUrl,
                contentType: "application/json; charset=utf-8",
                data: jsonData,
                success: function (res) {
                    if (STATUS.SUCCESS.code === res.code) {
                        resolve(res);
                    } else {
                        reject(res);
                    }
                },
                error: function (res) {
                    reject(res);
                }
            });
        } catch (e) {
            console.error(e);
            Alert(STATUS.ERROR.msg);
        }
    });
};

/**
 * ajax统一处理
 */
$.ajaxSetup({
    contentType: "application/json",
    timeout: 6000,
    beforeSend: function (xmlHttpRequest) {
        // 请求前执行的方法
        console.info("ajaxSetup.beforeSend");
    },
    complete: function (xmlHttpRequest, status) {
        // 请求完成执行的方法
        console.info("ajaxSetup.complete");
    },
    success: function (res, xmlHttpRequest, status) {
        // 请求成功执行的方法
        console.info("ajaxSetup.success");
    },
    error: function (xmlHttpRequest, status, error) {
        // 请求失败执行的方法
        console.info("ajaxSetup.error");
        Alert("ajax请求异常：[" + xmlHttpRequest.status + "][" + error.message + "]");
    }
});

