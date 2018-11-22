package com.convergence.designpattern.prototype;

public class MotorBike implements Product {

	private String tag;
	
	
	public MotorBike(String tag) {
		super();
		this.tag = tag;
	}

	@Override
	public void use(String s) {
		System.out.println("i m a"+s);
	}

	@Override
	public Product creatClone() {
		Product p=null;
		try {
			p = (Product) clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

}
