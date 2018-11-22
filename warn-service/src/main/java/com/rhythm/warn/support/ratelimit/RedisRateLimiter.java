package com.rhythm.warn.support.ratelimit;

import com.rhythm.warn.exception.RateLimitException;

import java.util.concurrent.TimeUnit;

/**
 * redis实现计数器限流
 *
 * @author majunjie
 * @date 2018/11/22 12:45
 */
public class RedisRateLimiter extends CounterRateLimiterInterface {

    public RedisRateLimiter(TimeUnit timeUnit, Long maxCount, CounterTargetInterface counterTarget) {
        super(timeUnit, maxCount, counterTarget);
    }

    @Override
    public void rateLimit() throws RateLimitException {

    }
}
