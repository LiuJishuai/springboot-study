package com.jeyson.springboot.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: liujishuai
 * @Time: 2018/6/6 10:45
 * @Description:
 */
@Service
public class RedisService {

    @Autowired
    RedisTemplate redisTemplate;

    public void setCache(String key,String value,int exp){
        ValueOperations<String,String> ops=redisTemplate.opsForValue();
        ops.set(key,value,exp, TimeUnit.SECONDS);
    }

    public String getCache(String key){
        ValueOperations<String,String> ops=redisTemplate.opsForValue();
        return ops.get(key);
    }

    public <T> T getCache(String key,Class<T> clazz){
         ValueOperations<String,String> ops=redisTemplate.opsForValue();
         return JSON.parseObject(ops.get(key),clazz);
    }
    public <T> void setCache(String key,T obj,int exp){
        ValueOperations<String,String> ops=redisTemplate.opsForValue();
        ops.set(key,JSON.toJSONString(obj),exp,TimeUnit.SECONDS);
    }
}
