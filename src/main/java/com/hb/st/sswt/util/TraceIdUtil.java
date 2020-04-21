package com.hb.st.sswt.util;

import java.util.UUID;

/**
 * trace_id上下文
 *
 * @author Mr.huang
 * @since 2020/4/20 17:29
 */
public class TraceIdUtil {

    /**
     * 存放trace_id的容器
     */
    private static final ThreadLocal<String> TRACE_ID = new InheritableThreadLocal();

    /**
     * 获取trace_id
     *
     * @return trace_id
     */
    public static String getTraceId() {
        return (String) TRACE_ID.get();
    }

    /**
     * 设置trace_id
     *
     * @param traceId trace_id
     */
    public static void setTraceId(String traceId) {
        TRACE_ID.set(traceId);
    }

    /**
     * 删除trace_id
     */
    public static void removeTraceId() {
        TRACE_ID.remove();
    }

    /**
     * 生成新的traceId
     *
     * @return 字符串
     */
    public static String generateTraceId() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }

}
