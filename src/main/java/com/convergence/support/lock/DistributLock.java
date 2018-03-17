package com.convergence.support.lock;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 第一种实现方式 . 锁的 value 值是当前时间加上过期时间的时间戳 锁的key 可以为与业务相关的唯一的东东
 * 
 * @author andy
 *
 */
@Component
public class DistributLock {
    private static final Logger log = LoggerFactory.getLogger(DistributLock.class);

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 这段代码问题在哪里？ 1. 由于是客户端自己生成过期时间，所以需要强制要求分布式下每个客户端的时间必须同步。 2. 当锁过期的时候，如果多个客户端同时执行 jedis.getSet()
     * 方法， 那么虽然最终只有一个客户端可以加锁，但是这个客户端的锁的过期时间可能被其他客户端覆盖。 3. 锁不具备拥有者标识，即任何客户端都可以解锁。
     * 
     * @param key
     * @param value
     * @return
     */
    public boolean lock(String key, String value) {
        // Set {@code key} to hold the string {@code value} if {@code key} is absent
        // 如果 键不存在 那么存入
        if (redisTemplate.opsForValue().setIfAbsent(key, value)) {// setNX
                                                                  // 返回boolean
            return true;
        }
        // 如果锁超时 ***
        String currentValue = redisTemplate.opsForValue().get(key);
        // 如果存在该键值,并且当前值得时间小于系统时间 也就是说时间戳做值的锁
        if (!StringUtils.isEmpty(currentValue)
                && Long.parseLong(currentValue) < System.currentTimeMillis()) {
            // 获取上一个锁的时间 getAndSet的方法意思为获得老值 插入覆盖新值
            String oldvalue = redisTemplate.opsForValue().getAndSet(key, value);
            // 判断老值是否为空,并且老锁的时间戳和当前的时间戳是否一致
            if (!StringUtils.isEmpty(oldvalue) && oldvalue.equals(currentValue)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 解锁 问题:可能会把别人的锁给干掉
     * 
     * @param key
     * @param value
     */
    public void unlock(String key, String value) {
        try {
            String currentValue = redisTemplate.opsForValue().get(key);
            // 获得当前锁,并判断当前
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        } catch (Exception e) {
            log.error("解锁异常");
        }
    }

}
