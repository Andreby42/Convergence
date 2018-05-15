package com.convergence.support.cache;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class LRUCache {

    private final ReentrantLock lock = new ReentrantLock();

    private final Map<String, Object> map = new ConcurrentHashMap<String, Object>();
    private final Deque<String> queue = new LinkedList<String>();
    private final int limit;

    public LRUCache(int limit) {
        this.limit = limit;
    }

}
