package com.convergence.designpattern.factory;

public abstract class AbstractFactory {
	public abstract AutoCar buildMotorWithSimpleFactory(Class<?> claz)throws InstantiationException, IllegalAccessException, ClassNotFoundException;
}
