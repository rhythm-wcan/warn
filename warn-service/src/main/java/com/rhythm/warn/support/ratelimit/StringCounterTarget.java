package com.rhythm.warn.support.ratelimit;

/**
 * 计数器目标对象
 *
 * @author majunjie
 * @date 2018/11/22 12:51
 */
public class StringCounterTarget implements CounterTargetInterface {

    private String target;

    public StringCounterTarget(String target) {
        this.target = target;
    }

    /**
     * 获取目标
     *
     * @return
     */
    @Override
    public String getTarget() {
        return target;
    }

}
