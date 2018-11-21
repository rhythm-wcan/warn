package com.rhythm.warn.config;

import com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author majunjie
 * @date 2018/11/21 15:55
 */
public class OptimisticLockVersionConfig  implements InitializingBean, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void afterPropertiesSet() throws Exception {
        MybatisSqlSessionFactoryBean mybatisFactoryBean = applicationContext
                .getBean(MybatisSqlSessionFactoryBean.class);
        if (mybatisFactoryBean != null) {
            PaginationInterceptor pagination = new PaginationInterceptor();
            pagination.setLocalPage(true);
            OptimisticLockerInterceptor optimisticLocker = new OptimisticLockerInterceptor();
            mybatisFactoryBean.setPlugins(new Interceptor[] { pagination, optimisticLocker });
            mybatisFactoryBean.afterPropertiesSet();
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}
