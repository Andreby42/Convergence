package com.convergence.designpattern.factory;

public class BusFactory implements FactoryMethodMotorFactory {

	@Override
	public AutoCar buildMotorWithFactoryMethod() {
		return  new Bus();
	}

}
