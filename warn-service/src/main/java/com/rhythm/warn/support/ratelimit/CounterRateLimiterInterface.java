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
     * 时间单位
     */
    protected TimeUnit timeUnit;
    /**
     * 单位时间上限
     */
    protected Long maxCount;
    /**
     * 限流目标
     */
    protected CounterTargetInterface counterTarget;

    public CounterRateLimiterInterface(TimeUnit timeUnit, Long maxCount, CounterTargetInterface counterTarget) {
        this.timeUnit = timeUnit;
        this.maxCount = maxCount;
        this.counterTarget = counterTarget;
    }

}
