package com.rhythm.warn.config;

import com.rhythm.warn.interceptor.RateLimiterInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author majunjie
 * @date 2018/11/21 15:53
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new RateLimiterInterceptor());
//        super.addInterceptors(registry);
    }

}
