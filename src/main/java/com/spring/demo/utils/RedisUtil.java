package com.spring.demo.utils;

import com.spring.demo.constant.RedisConstant;

import java.text.MessageFormat;

import static com.spring.demo.constant.BaseConstant.REDIS_KEY_FORMAT;

/**
 * redis工具类
 */
public class RedisUtil {
    /**
     * 格式化Redis的KEY，
     * Redis的KEY统一采用如下格式生成：{系统名}-{业务模块名}-{业务ID}, 以免多系统复用Redis的时候到账KEY重复。
     * @param module
     * @param key
     * @return
     */
    public static final String formatRedisKey(RedisConstant module, String key) {
        if (module == null || key == null) {
            throw new IllegalArgumentException("待生成的RedisKey的模块名和业务主键均不允许为空");
        }
        return MessageFormat.format(REDIS_KEY_FORMAT, module.name(), key);
    }

}
