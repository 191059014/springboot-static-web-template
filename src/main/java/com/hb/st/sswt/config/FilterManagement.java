package com.hb.st.sswt.config;

import com.hb.st.sswt.filter.SecurityFilter;
import com.hb.st.sswt.filter.TraceIdFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * 过滤器管理
 *
 * @author Mr.huang
 * @since 2020/4/21 9:43
 */
@Configuration
public class FilterManagement {

    /**
     * org.slf4j.Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TraceIdFilter.class);

    /**
     * traceIdFilter
     */
    @Bean
    public FilterRegistrationBean traceIdFilter() {
        return buildSimpleFilter(new TraceIdFilter(), "/controller/*", "traceIdFilter", true, 0);
    }

    /**
     * securityFilter
     */
    @Bean
    public FilterRegistrationBean securityFilter() {
        return buildSimpleFilter(new SecurityFilter(), "/controller/*", "securityFilter", true, 1);
    }

    /**
     * 构建简单的filter
     *
     * @param filter      具体的filter
     * @param urlPatterns 拦截路径
     * @param filterName  过滤器名称
     * @param enable      是否自动注册
     * @param order       顺序
     * @return FilterRegistrationBean
     */
    private FilterRegistrationBean buildSimpleFilter(Filter filter, String urlPatterns, String filterName, boolean enable, int order) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(filter);
        registration.addUrlPatterns(urlPatterns);
        registration.setName(filterName);
        registration.setEnabled(enable);
        registration.setOrder(order);
        LOGGER.info("{} register success", filterName);
        return registration;
    }

}
