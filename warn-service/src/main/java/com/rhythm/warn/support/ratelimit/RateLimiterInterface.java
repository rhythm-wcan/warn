package com.rhythm.warn.support.ratelimit;

import com.rhythm.warn.exception.RateLimitException;

/**
 * 限流接口
 *
 * @author majunjie
 * @date 2018/11/22 12:45
 */
public interface RateLimiterInterface {

    /**
     * 限流
     *
     * @throws RateLimitException
     */
    void rateLimit() throws RateLimitException;

}
