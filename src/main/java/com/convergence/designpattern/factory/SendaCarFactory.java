package com.convergence.designpattern.factory;

public class SendaCarFactory implements FactoryMethodMotorFactory {

	@Override
	public AutoCar buildMotorWithFactoryMethod() {
		return new SendaCar();
	}

}
