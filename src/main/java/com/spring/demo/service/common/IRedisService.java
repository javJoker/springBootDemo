package com.spring.demo.service.common;

public interface IRedisService {

    /**
     * 设置redis缓存
     * @param key
     * @param value
     * @param <T>
     * @return
     */
    public <T> Boolean set(String key, T value);
}
