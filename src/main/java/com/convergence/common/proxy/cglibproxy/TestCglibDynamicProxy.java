package com.convergence.common.proxy.cglibproxy;

public class TestCglibDynamicProxy {
	public static void main(String[] args) {
		CglibDynamicProxy cdp = new CglibDynamicProxy();
		Cat instance = (Cat) cdp.getInstance(new Cat());
		instance.eat();

	}
}
