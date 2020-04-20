package com.hb.st.sswt.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hb.st.sswt.util.TraceIdUtil;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.helpers.MessageFormatter;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日志类
 *
 * @author Mr.huang
 * @since 2020/4/20 16:56
 */
public final class Logger {

    /**
     * org.slf4j.Logger
     */
    private org.slf4j.Logger delegateLogger;

    /**
     * 构造方法
     *
     * @param o 根据此参数来构建日志对象
     */
    Logger(Object o) {
        if (o == null) {
            throw new IllegalArgumentException("构建日志的参数不能为空");
        }
        if (o instanceof String) {
            delegateLogger = LoggerFactory.getLogger((String) o);
        } else if (o instanceof Class) {
            delegateLogger = LoggerFactory.getLogger((Class) o);
        } else {
            throw new IllegalArgumentException("构建日志的参数类型有误");
        }
    }

    /**
     * info级别的日志打印
     *
     * @param format    格式化的日志信息
     * @param arguments 参数
     */
    public void info(String format, Object... arguments) {
        Object message = this.getLogMsg(format, arguments);
        JSONObject jsonObject = this.buildLogTemplate(message, Thread.currentThread().getStackTrace(), "INFO");
        this.delegateLogger.info(jsonObject.toJSONString());
    }

    /**
     * error级别的日志打印
     *
     * @param format    格式化的日志信息
     * @param arguments 参数
     */
    public void error(String format, Object... arguments) {
        Object message = this.getLogMsg(format, arguments);
        JSONObject jsonObject = this.buildLogTemplate(message, Thread.currentThread().getStackTrace(), "ERROR");
        this.delegateLogger.info(jsonObject.toJSONString());
    }

    /**
     * 构建日志信息模板
     *
     * @return 标准日志
     */
    private JSONObject buildLogTemplate(Object message, StackTraceElement[] stacks, String logLevel) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("content", message);
        jsonObject.put("log_level", logLevel);
        jsonObject.put("trace_id", TraceIdUtil.getTraceId());
        jsonObject.put("file_name", stacks[2].getClassName());
        jsonObject.put("file_line", stacks[2].getLineNumber());
        jsonObject.put("log_date", (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")).format(new Date(System.currentTimeMillis())));
        return jsonObject;
    }

    /**
     * 组装日志信息
     *
     * @param format   格式化的字符串
     * @param argArray 参数数组
     * @return FormattingTuple对象
     */
    private Object getLogMsg(String format, Object[] argArray) {
        return MessageFormatter.arrayFormat(format, argArray, null).getMessage();
    }

}
