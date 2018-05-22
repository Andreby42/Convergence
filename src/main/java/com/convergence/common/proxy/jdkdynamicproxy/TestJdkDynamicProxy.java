package com.convergence.common.proxy.jdkdynamicproxy;

import com.convergence.common.proxy.staticproxy.Animal;

public class TestJdkDynamicProxy {
	/**
	 *  动态代理在拿到代理对象后才知道代理的是谁。 代理类要与被代理对象实现同一个接口，也就是说只能对实现了接口的类进行实现。不能针对某个类
	 * @param args 
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException {
		//实例目标对象
		Animal rabbit = new Rabbit();
		//创建代理累
		DynamicProxyHandler<Animal> proxy= new DynamicProxyHandler<Animal>(rabbit);
		//获得代理对象
		Animal instance = (Animal) proxy.getInstance();

		//反射调用
		instance.eat();
	}
}
