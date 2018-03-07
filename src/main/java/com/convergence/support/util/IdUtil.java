package com.convergence.support.util;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IdUtil {
    private static final long ONE_STEP = 10;
    private static final Lock LOCK = new ReentrantLock();
    private static long lastTime = System.currentTimeMillis();
    private static short lastCount = 0;
    private static int count = 0;

    @SuppressWarnings("finally")
    public static Long nextId() {
        LOCK.lock();
        try {
            if (lastCount == ONE_STEP) {
                boolean done = false;
                while (!done) {
                    long now = System.currentTimeMillis();
                    if (now == lastTime) {
                        try {
                            Thread.currentThread();
                            Thread.sleep(1);
                        } catch (java.lang.InterruptedException e) {}
                        continue;
                    } else {
                        lastTime = now;
                        lastCount = 0;
                        done = true;
                    }
                }
            }
            count = lastCount++;
        } finally {
            LOCK.unlock();
            return Long.valueOf(lastTime + "" + String.format("%03d", count));
        }
    }

    @SuppressWarnings("finally")
    public static Long next9Id() {
        LOCK.lock();
        try {
            if (lastCount == ONE_STEP) {
                boolean done = false;
                while (!done) {
                    long now = System.currentTimeMillis();
                    if (now == lastTime) {
                        try {
                            Thread.currentThread();
                            Thread.sleep(1);
                        } catch (java.lang.InterruptedException e) {}
                        continue;
                    } else {
                        lastTime = now;
                        lastCount = 0;
                        done = true;
                    }
                }
            }
            count = lastCount++;
        } finally {
            LOCK.unlock();
            String code = Long.valueOf(lastTime + "" + String.format("%03d", count)).toString();
            code = code.substring(7);
            return Long.valueOf(code);
            /*
             * StringBuffer sb = new
             * StringBuffer(Long.valueOf(lastTime+""+String.format("%03d",count)).toString()); for
             * (int i = 0; i < 7; i++) { int nextInt = RandomUtils.nextInt(10);
             * sb.deleteCharAt(nextInt); } // System.out.println(Long.valueOf(sb.toString()));
             * return Long.valueOf(sb.toString()); }
             */
        }
    }

    public static void main(String[] args) {
        // 测试
        for (int i = 0; i < 1000; i++) {
            System.out.println(nextId());
        }
    }
}
