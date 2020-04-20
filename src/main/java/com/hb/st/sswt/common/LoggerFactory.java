package com.hb.st.sswt.common;

/**
 * 日志工厂
 *
 * @author Mr.huang
 * @since 2020/4/20 16:56
 */
public final class LoggerFactory {

    /**
     * 通过字符串来构建日志对象
     *
     * @param aString 字符串
     * @return com.hb.st.sswt.common.Logger
     */
    public static Logger getLogger(String aString) {
        return new Logger(aString);
    }

    /**
     * 通过字符串来构建日志对象
     *
     * @param aClass 类
     * @return com.hb.st.sswt.common.Logger
     */
    public static Logger getLogger(Class aClass) {
        return new Logger(aClass);
    }

}
