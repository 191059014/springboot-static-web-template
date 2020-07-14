import * as EnvConfig from "../config/env_config.js";
import {STATUS} from "./consts.js";

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
        $.ajax({
            type: "get",
            url: fullRequestUrl,
            success: function (res) {
                resolve(res);
            }
            // 此处不加error方法，下面ajaxSetup有统一处理
        });
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
        $.ajax({
            type: "post",
            url: fullRequestUrl,
            contentType: "application/json; charset=utf-8",
            data: jsonData,
            success: function (res) {
                resolve(res);
            }
            // 此处不加error方法，下面ajaxSetup有统一处理
        });
    });
};

/**
 * ajax统一处理
 */
$.ajaxSetup({
    contentType: "application/json",
    timeout: 10000,
    beforeSend: function (xmlHttpRequest) {
        debugger;
        // 请求前执行的方法
        console.info("ajaxSetup.beforeSend");
    },
    complete: function (xmlHttpRequest, status) {
        debugger;
        // 请求完成执行的方法
        console.info("ajaxSetup.complete");
    },
    error: function (xmlHttpRequest, status, error) {
        console.error("ajaxSetup.error");
        // 请求失败执行的方法
        if (xmlHttpRequest.responseJSON) {
            let statusCode = xmlHttpRequest.responseJSON.status;
            switch (statusCode) {
                case 400:
                    Alert("错误的请求！");
                    break;
                case 403:
                    Alert("无权访问！");
                    break;
                case 404:
                    Alert("请求的资源无效！");
                    break;
                case 405:
                    Alert("请求的参数或格式不正确！");
                    break;
                default:
                    Alert(STATUS.ERROR.msg);
            }
        }
    }
});

