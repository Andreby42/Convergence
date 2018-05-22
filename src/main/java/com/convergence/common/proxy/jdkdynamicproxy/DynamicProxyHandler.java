package com.convergence.common.proxy.jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class  DynamicProxyHandler<T> implements InvocationHandler {
	//指定目标代理对象
	private T target;
	

	public T getTarget() {
		return target;
	}


	public void setTarget(T target) {
		this.target = target;
	}


	public DynamicProxyHandler(T target) {
		super();
		this.target = target;
	}

	/**
	 * 真正调用方法的反射方法
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return method.invoke(target, args);
	}
	public Object  getInstance() throws InstantiationException, IllegalAccessException, IllegalArgumentException{
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),   
                target.getClass().getInterfaces(), this);
	}

}
