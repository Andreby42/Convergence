package com.convergence.common.proxy.jdkdynamicproxy;

import com.convergence.common.proxy.staticproxy.Animal;

public class Rabbit implements Animal {

	@Override
	public void eat() {
		System.out.println("rabbit eated....");
	}

}
