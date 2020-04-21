package com.hb.st.sswt.filter;

import com.hb.st.sswt.util.TraceIdUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * traceId的过滤器
 *
 * @author Mr.huang
 * @since 2020/4/21 9:07
 */
public class TraceIdFilter implements Filter {

    /**
     * org.slf4j.Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TraceIdFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.info("requestURI:{}", ((HttpServletRequest) servletRequest).getRequestURI());
        try {
            // 初始化traceId
            String traceId = servletRequest.getParameter("traceId");
            if (StringUtils.isEmpty(traceId)) {
                TraceIdUtil.setTraceId(TraceIdUtil.generateTraceId());
            } else {
                TraceIdUtil.setTraceId(traceId);
            }
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            // 销毁traceId
            TraceIdUtil.removeTraceId();
        }
    }

}
