package com.convergence.designpattern.singleton;

public class SingletonDemo {
	/**
	 * 饿汉式
	 */
	private static SingletonDemo ehan = new SingletonDemo();

	public SingletonDemo() {
	}

	public static SingletonDemo getSingleton() {
		return ehan;
	}

	/**
	 * 懒汉式
	 */
	private static SingletonDemo lanhan;

	public static SingletonDemo getLanHanInstance() {
		if (lanhan == null) {
			synchronized (SingletonDemo.class) {
				if (lanhan == null) {
					lanhan = new SingletonDemo();
				}

			}
		}
		return ehan;

	}

	// 静态内部类
	private static class Holder {
		private static SingletonDemo staticInstance = new SingletonDemo();
	}

	public static SingletonDemo getInnerStaticInstance() {
		return Holder.staticInstance;
	}

	// 枚举方式
	public enum SingletonEnum {
		INSTANCE;
		private SingletonDemo inctance;

		SingletonEnum() {
			inctance = new SingletonDemo();
		}

		public SingletonDemo getInstance() {
			return inctance;
		}

	}

}
