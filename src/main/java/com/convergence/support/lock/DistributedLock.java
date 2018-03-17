package com.convergence.support.lock;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

@Component
public class DistributedLock {
    private static final Logger log = LoggerFactory.getLogger(DistributedLock.class);
    private static final Long RELEASE_SUCCESS = 1L;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * TODO: 做异常处理
     * 
     * @param key锁的key
     * @param value 可以为thead 可以为机器唯一key
     * @param lockTimeOut 锁超时时间 避免死锁
     * @param lockValue 锁的值
     * @param
     * @return
     */
    public boolean distributedLock(String key, String value, long lockTimeOut) {
        // 针对单机版redis 分布式锁 取 单机redis的时间为系统时间 严格保证时间一致
        Long redisTime = redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.time();
            }
        });
        long lockValue = redisTime + lockTimeOut;
        if (redisTemplate.opsForValue().setIfAbsent(key, String.valueOf(lockValue))) {// setNX
            // 加锁成功
            // 设置锁释放时间 避免死锁
            redisTemplate.expire(key, lockTimeOut, TimeUnit.MILLISECONDS);
            return true;
        }

        Long currt_lock_timeout_Str = (Long) redisTemplate.opsForValue().get(key); // redis里的lockValue
        if (currt_lock_timeout_Str != null
                && currt_lock_timeout_Str < redisTemplate.execute(new RedisCallback<Long>() {
                    @Override
                    public Long doInRedis(RedisConnection connection) throws DataAccessException {
                        return connection.time();
                    }
                })) {
            // 锁已经失效
            // 判断是否为空，不为空的情况下，说明已经失效，如果被其他线程设置了值，则第二个条件判断是无法执行
            Long old_lock_timeout_Str =
                    (Long) redisTemplate.opsForValue().getAndSet(key, lockValue);
            // 获取上一个锁到期时间，并设置现在的锁到期时间
            if (old_lock_timeout_Str != null
                    && old_lock_timeout_Str.equals(currt_lock_timeout_Str)) {
                // 如过这个时候，多个线程恰好都到了这里，但是只有一个线程的设置值和当前值相同，他才有权利获取锁
                log.info(value + "加锁成功");
                redisTemplate.expire(key, lockTimeOut, TimeUnit.MILLISECONDS); // 设置超时时间，释放内存
                return true;// 返回成功标志
            }
        }
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } // 睡眠100毫秒
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
            String currentValue = (String) redisTemplate.opsForValue().get(key);
            // 获得当前锁,并判断当前
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        } catch (Exception e) {
            log.error("解锁异常");
        }
    }
    /**
     * 
     * @param lockKey 锁的键
     * @param lockValue 锁的value 一般为 请求id啊 业务唯一id,
     * @param expireTime 锁的超时时间 过期释放锁 避免死机死锁
     * @return
     */
    public boolean distributedLock2(String lockKey, String lockValue, int expireTime) {
        if (redisTemplate.opsForValue().setIfAbsent(lockKey, lockValue)
                && redisTemplate.expire(lockKey, expireTime, TimeUnit.MILLISECONDS)) {// setNX
            return true;
        }
        return false;
    }

    /**
     * 
     * @param lockKey 锁的键
     * @param lockValue 锁的value 一般为 请求id啊 业务唯一id,
     * @return
     */
    public boolean releaseDistributedLock2(String lockKey, String lockValue) {

        String script =
                "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        DefaultRedisScript<Boolean> defaultRedisScript =
                new DefaultRedisScript<>(script, Boolean.class);
        Boolean result = redisTemplate.execute(defaultRedisScript,
                Collections.singletonList(lockKey), Collections.singletonList(lockValue));
        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }
}
