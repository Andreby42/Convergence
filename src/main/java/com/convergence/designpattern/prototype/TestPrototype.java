package com.convergence.designpattern.prototype;

import org.apache.catalina.Manager;

public class TestPrototype {

	public static void main(String[] args) {
		ProductManager manager = new ProductManager();
		MotorBike motorBike = new MotorBike("motorbike");
		MotorTricycle motorTricycle = new MotorTricycle("motorTricycle");
		
		manager.register("m",motorBike);
		manager.register("t",motorTricycle);
		
		Product m1 = manager.createProduct("m");
		Product m2 = manager.createProduct("m");
		m1.use("m1");
		m2.use("m2");
		
		Product t1 = manager.createProduct("t");
		Product t2 = manager.createProduct("t");
		t1.use("t1");
		t2.use("t2");

	}
}
