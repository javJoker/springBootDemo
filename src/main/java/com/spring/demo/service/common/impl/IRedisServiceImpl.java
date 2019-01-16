package com.spring.demo.service.common.impl;

import com.spring.demo.service.common.IRedisService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

@Service
public class IRedisServiceImpl implements IRedisService {

    private Logger LOG =  Logger.getLogger( IRedisServiceImpl.class);

    // 在构造器中获取redisTemplate实例, key(not hashKey) 默认使用String类型
    private RedisTemplate<String, Object> redisTemplate;

    // 在构造器中通过redisTemplate的工厂方法实例化操作对象
    private HashOperations<String, Object, Object> hashOperations;
    private ListOperations<String, Object> listOperations;
    private ZSetOperations<String, Object> zSetOperations;
    private SetOperations<String, Object> setOperations;
    private ValueOperations<String, Object> valueOperations;

    @Autowired
    public IRedisServiceImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
        this.listOperations = redisTemplate.opsForList();
        this.zSetOperations = redisTemplate.opsForZSet();
        this.setOperations = redisTemplate.opsForSet();
        this.valueOperations = redisTemplate.opsForValue();
    }


    /**
     * 设置redis缓存
     * @param key
     * @param value
     * @param <T>
     * @return
     */
    @Override
    public <T> Boolean set(String key, T value) {
        if (StringUtils.isNotBlank(key)) {
            valueOperations.set(key, value);
            return true;
        }
        return false;
    }
}
