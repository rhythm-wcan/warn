package com.rhythm.warn.support.ratelimit;

import com.rhythm.warn.exception.RateLimitException;

import java.util.concurrent.TimeUnit;

/**
 * redis实现单秒计数器限流
 *
 * @author majunjie
 * @date 2018/11/22 12:45
 */
public class RedisSecondCounterRateLimiter extends CounterRateLimiterInterface {

    /**
     *
     */
    private TimeUnit timeUnit;
    /**
     *
     */
    private Long maxCount;
    /**
     *
     */
    private CounterTargetInterface counterTarget;


    @Override
    public void rateLimit() throws RateLimitException {

        //比较上一次规则，初始化轮询数组

        //是否清零当前数组（当前数组比较上一个更新数组），注意并发（使用cas）

        //对应数组计数器+1，记录更新数组

        //统计单位时间访问次数

        //记录上一次规则

        //比较最大限流

    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public void setMaxCount(Long maxCount) {
        this.maxCount = maxCount;
    }

    public void setCounterTarget(CounterTargetInterface counterTarget) {
        this.counterTarget = counterTarget;
    }

    @Override
    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    @Override
    public Long getMaxCount() {
        return maxCount;
    }

    @Override
    public CounterTargetInterface getCounterTarget() {
        return counterTarget;
    }
}
