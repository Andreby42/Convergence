package com.convergence.common.proxy.cglibproxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibDynamicProxy implements MethodInterceptor {
	
	private Object target;
	private Class<?> targetClaz;
	
			
	public Class<?> getTargetClaz() {
		return targetClaz;
	}
	public void setTargetClaz(Class<?> targetClaz) {
		this.targetClaz = targetClaz;
	}
	/**
	 * 实例对象获得
	 * @param target
	 * @return
	 */
	public Object getInstance(Object target) {
		this.target = target;
		//创建一个织入器
		Enhancer enhancer = new Enhancer();
		//设置父类
		enhancer.setSuperclass(this.target.getClass());
		//设置需要置入的逻辑
		enhancer.setCallback(this);
		//创建代理对象 就是使用织入器创建要代理类的子类。这个子类由asm
		return enhancer.create();
	}
	/**
	 * 只传入代理class
	 * @param targetClaz
	 * @return
	 */
	public Object getInstance(Class<?> targetClaz) {
		this.targetClaz=targetClaz;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(targetClaz);
		enhancer.setCallback(this);
		return enhancer.create();
	}
	/***
	 *  有的时候 有的被代理类只有有参构造方法,没有无参构造方法。只有有参构造方法。
	 * @param targetClaz
	 * @param argumentTypes
	 * @param arguments
	 * @return
	 */
	public Object getInstance(Class<?> targetClaz,Class<?> []argumentTypes,Object[] arguments) {
		this.targetClaz=targetClaz;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(targetClaz);
		enhancer.setCallback(this);
		/**
		 * 创建有参构造的代理子类
		 */
		return enhancer.create(argumentTypes, arguments);
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
