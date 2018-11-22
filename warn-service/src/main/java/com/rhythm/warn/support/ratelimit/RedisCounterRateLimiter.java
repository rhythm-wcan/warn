package com.rhythm.warn.support.ratelimit;

import com.rhythm.warn.exception.RateLimitException;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * redis实现计数器限流
 *
 * @author majunjie
 * @date 2018/11/22 12:45
 */
public class RedisCounterRateLimiter extends CounterRateLimiterInterface {

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
