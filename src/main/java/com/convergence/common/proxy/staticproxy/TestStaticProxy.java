package com.convergence.common.proxy.staticproxy;
/**
 *  静态代理的实现.
 * @author ander
 *
 */
public class TestStaticProxy {
	/**
	 * 静态代理实现。 要代理的类的class文件已经存在了
	 * @param args
	 */
	public static void main(String[] args) {
		Animal dog = new Dog();
		AnimalProxy proxy= new AnimalProxy(dog);
		proxy.eat();
	}

}
