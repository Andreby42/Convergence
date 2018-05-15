package com.convergence.common.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class Task_2 extends Thread {

    private String name;

    public Task_2(String name) {
        super();
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.name + " running ........");
        }

    }

    public class TestArray {

        private TestArray ta1 = new TestArray();
        private TestArray ta2 = new TestArray();

        @Test
        public void t1() {
            final AtomicInteger ai = new AtomicInteger(0);
            int i = 0;
            while (i < 100) {
                i++;
                new Thread() {
                    public void run() {
                        synchronized (ta1) {
                            synchronized (ta2) {
                                System.out.println(ai.getAndIncrement());
                            }
                        }
                    }
                }.start();
            }

        }
    }


}
