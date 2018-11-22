package com.convergence.designpattern.factory;

public class AutoMotorFactory<T> extends AbstractFactory {
	/**
	 * 使用反射构建简单工厂
	 * 
	 * @param claz
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	@Override
	public AutoCar buildMotorWithSimpleFactory(Class<?> claz)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return (AutoCar) claz.forName(claz.getName()).newInstance();
	}

	public static AutoCar buildMobileWithSimpleFactory(Class<?> claz) {
		if (claz.isInstance(Bus.class)) {
			return new Bus();
		} else if (claz.isInstance(SendaCar.class)) {
			return new SendaCar();
		}else {
			throw new RuntimeException("Can not instalize a instance");
		}
	}


}
