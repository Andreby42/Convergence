package com.convergence.support.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁与非公平锁 之RetrantLock
 * 
 * @author andreby
 *
 */
public class RetrantLockDemo extends Thread {
	private Object o = new Object();

	private static Object staticObj = new Object();

	private ReentrantLock reentrantLock;

	public RetrantLockDemo(boolean isFair) {
		super();
		this.reentrantLock = new ReentrantLock(isFair);
	}

	public void testLock() {
		try {
			reentrantLock.lock();
			System.out.println("线程=" + Thread.currentThread().getName() + "已锁定");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something is wrong with it ");
		} finally {
			reentrantLock.unlock();
		}
	}

	public static synchronized void testStaticSyn() {
		System.out.println("synchronized 获取到锁了,当前线程=" + Thread.currentThread().getName());
		try {
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void testNoStaticStaticSyn() {
		System.out.println("synchronized 获取到锁了,当前线程=" + Thread.currentThread().getName());
		try {
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testBlockSynOnInstanceMember() {
		synchronized (o) {
			try {
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println("代码块拿到锁了");
			}
		}
	}

	public void testBlockSynOnStaticMember() {
		synchronized (staticObj) {
			try {
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println("代码块拿到锁了");
			}
		}
	}

	/**
	 * 进行main方法测试公平锁
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 指定使用公平锁
		/*
		 * RetrantLockDemo fairLock = new RetrantLockDemo(true); Thread thread = new
		 * Thread(new Runnable() {
		 * 
		 * @Override public void run() { System.out.println("进来申请锁了" +
		 * Thread.currentThread().getName()); fairLock.testLock(); } }); ExecutorService
		 * fairexecutorService = Executors.newCachedThreadPool(); for (int i = 0; i <
		 * 10; i++) { fairexecutorService.execute(thread); } // 使用非公平锁 RetrantLockDemo
		 * unFairLock = new RetrantLockDemo(false); Thread unFairThread = new Thread(new
		 * Runnable() {
		 * 
		 * @Override public void run() { System.out.println("进来申请锁了当前线程=" +
		 * Thread.currentThread().getName()); unFairLock.testLock(); } });
		 * System.out.println(
		 * "=====================非公平锁retrantLock===========================");
		 * ExecutorService unfairexecutorService = Executors.newCachedThreadPool(); for
		 * (int i = 0; i < 10; i++) { unfairexecutorService.execute(unFairThread); }
		 * System.out.println(
		 * "=====================非公平锁synchronized==========================="); Thread
		 * synThread = new Thread(new Runnable() {
		 * 
		 * @Override public void run() { System.out.println("进来申请锁了当前线程=" +
		 * Thread.currentThread().getName()); RetrantLockDemo.testStaticSyn(); } });
		 * ExecutorService synexecutorService = Executors.newCachedThreadPool(); for
		 * (int i = 0; i <5; i++) { synexecutorService.execute(synThread); }
		 */
		/*
		 * System.out.println(
		 * "=====================非公平锁实例方法synchronized===========================");
		 * 
		 * Thread synNoStaticThread = new Thread(new Runnable() {
		 * 
		 * @Override public void run() { System.out.println("进来申请锁了当前线程=" +
		 * Thread.currentThread().getName()); RetrantLockDemo demo= new
		 * RetrantLockDemo(false); demo.testNoStaticStaticSyn(); } }); ExecutorService
		 * synexecutorService = Executors.newCachedThreadPool(); for (int i = 0; i <10;
		 * i++) { synexecutorService.execute(synNoStaticThread); }
		 */
		/*
		 * System.out.println(
		 * "=====================非公平锁实例方法不同对象synchronized===========================");
		 * RetrantLockDemo demo1 = new RetrantLockDemo(false); RetrantLockDemo demo2=
		 * new RetrantLockDemo(false); RetrantLockDemo demo3 = new
		 * RetrantLockDemo(false); RetrantLockDemo demo4 = new RetrantLockDemo(false);
		 * demo1.start(); demo2.start(); demo3.start(); demo4.start();
		 */

		System.out.println("=====================非公平锁代码块===========================");

		Thread synNoStaticThread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("进来申请锁了当前线程=" + Thread.currentThread().getName());
				RetrantLockDemo demo = new RetrantLockDemo(false);
				demo.testNoStaticStaticSyn();
			}
		});
		ExecutorService synexecutorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			synexecutorService.execute(synNoStaticThread);
		}

	}

	@Override
	public void run() {
		testNoStaticStaticSyn();
	}

}
