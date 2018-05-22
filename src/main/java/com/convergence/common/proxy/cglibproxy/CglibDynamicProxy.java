package com.convergence.common.proxy.cglibproxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibDynamicProxy implements MethodInterceptor {
	
	private Object target;
	
			
	/**
	 * 实例对象获得
	 * @param target
	 * @return
	 */
	public Object getInstance(Object target) {
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}



	public Object getTarget() {
		return target;
	}



	public void setTarget(Object target) {
		this.target = target;
	}



	@Override
	public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		return proxy.invokeSuper(object, args);
	}

}
