package com.hb.st.sswt.config;

import com.hb.st.sswt.filter.SecurityFilter;
import com.hb.unic.base.util.FilterUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


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
    private static final Logger LOGGER = LoggerFactory.getLogger(FilterManagement.class);

    /**
     * securityFilter
     */
    @Bean
    public FilterRegistrationBean securityFilter() {
        return FilterUtils.buildSimpleFilter(new SecurityFilter(), "/controller/*", "securityFilter", true, 1);
    }

}
