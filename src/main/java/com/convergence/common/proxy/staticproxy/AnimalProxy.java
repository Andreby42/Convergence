package com.convergence.common.proxy.staticproxy;

public class AnimalProxy implements Animal{
	private Animal animal ;

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public AnimalProxy(Animal animal) {
		super();
		this.animal = animal;
	}

	@Override
	public void eat() {
		this.animal.eat();
	}
	

}
