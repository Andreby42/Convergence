package com.convergence.common.concurrent;

public class SequenceJob {


    public static void main(String[] args) throws InterruptedException {
         Task_1 t1 = new Task_1("小明");
         Task_2 t2 = new Task_2("小红");
         
         t2.start();
         t2.join();
         t1.start();
    }

}
