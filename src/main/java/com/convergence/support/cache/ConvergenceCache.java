package com.convergence.support.cache;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2017/4/2.
 */
@Component("convergenceCache")
@CacheConfig(cacheNames = "CCache")
public class ConvergenceCache {

    @CachePut(key = "#p0")
    public Object set(String key, Object value) {
        return value;
    }

    @Cacheable(key = "#p0")
    public Object get(String key) {
        return null;
    }

    @CacheEvict(key = "#p0")
    public void delete(String key) {}

    @CachePut(key = "#p0 + ':' +  #p1")
    public Object set(String type, String key, Object value) {
        return value;
    }

    @Cacheable(key = "#p0 + ':' +  #p1")
    public Object get(String type, String key) {
        return null;
    }

    @CacheEvict(key = "#p0 + ':' +  #p1")
    public void delete(String type, String key) {}

}
