package com.rhythm.warn.support.ratelimit;

import java.util.concurrent.TimeUnit;

/**
 * 限流接口
 *
 * @author majunjie
 * @date 2018/11/22 12:45
 */
public abstract class CounterRateLimiterInterface implements RateLimiterInterface {

    /**
     * 获取时间单位
     *
     * @return
     */
    public abstract TimeUnit getTimeUnit() ;

    /**
     * 获取单位时间，限流上限
     * @return
     */
    public abstract Long getMaxCount() ;

    /**
     * 获取限流对象
     *
     * @return
     */
    public abstract CounterTargetInterface getCounterTarget() ;
}
