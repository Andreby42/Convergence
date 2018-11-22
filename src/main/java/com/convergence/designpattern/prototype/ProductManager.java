package com.convergence.designpattern.prototype;

import java.util.HashMap;

public class ProductManager {
	private HashMap<String, Product> products = new HashMap<String, Product>();

	/**
	 * 将product的命名和他的子类注册到Map中
	 * 
	 * @param name
	 * @param product
	 */
	public void register(String name, Product product) {
		products.put(name, product);
	}

	/**
	 * 根据命名从map容器中获取到具体的实现，然后进行clone
	 * 
	 * @param name
	 * @return
	 */
	public Product createProduct(String name) {
		Product product = products.get(name);
		return product.creatClone();
	}
}
