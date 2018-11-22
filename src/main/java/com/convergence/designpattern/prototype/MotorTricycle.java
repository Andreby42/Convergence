package com.convergence.designpattern.prototype;

public class MotorTricycle implements Product {
	private String tag;

	public MotorTricycle(String tag) {
		super();
		this.tag = tag;
	}

	@Override
	public void use(String s) {
		System.out.println("im a"+s);
		
	}

	@Override
	public Product creatClone() {
		Product p = null;
		try {
			p=(Product) clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return p;
	}

}
