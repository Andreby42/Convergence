package com.convergence.common.concurrent;

public class Task_1 extends Thread {
    private String name;

    public Task_1(String name) {
        super();
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.name + " running ........");
        }
    }

}
