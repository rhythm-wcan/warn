package com.rhythm.warn;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

/**
 * 项目启动类
 *
 * @author majunjie
 * @date 2018/11/19 13:17
 */
@EnableRetry
@EnableAsync
@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
@EnableAspectJAutoProxy(exposeProxy = true)
@MapperScan("com.rhythm.warn.mapper")
@ComponentScan(value = {"com.wn.common.cache"})
@ComponentScan(value = {"com.wn.common.lock"})
@EnableSwagger2Doc
public class WarnServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarnServiceApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        //生成一个设置了连接超时时间、请求超时时间、异常最大重试次数的httpClient
        RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(10000).setConnectTimeout(10000)
                .setSocketTimeout(30000).build();
        HttpClientBuilder builder = HttpClientBuilder.create().setDefaultRequestConfig(config)
                .setRetryHandler(new DefaultHttpRequestRetryHandler(3, true));
        HttpClient httpClient = builder.build();
        //使用httpClient创建一个ClientHttpRequestFactory的实现
        ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        //解决中文乱码
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }
}
