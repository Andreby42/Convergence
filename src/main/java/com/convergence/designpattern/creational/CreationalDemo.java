package com.convergence.designpattern.creational;
/**
 * 建造者模式
 * @author andreby
 *
 */
/**
 * 当我们需要进行构建一个复杂对象的时候 将构建过程进行抽离
 * 相同的方法不同的执行顺序产生不同的事件结果
 * 当一个对象的构建需要过多属性的时候而且某些参数有默认值 那么也可以考虑使用这个模式
 *
 */
public class CreationalDemo {

	private String name;

	private String age;

	private String addr;

	public String getName() {
		return name;
	}

	private CreationalDemo(CreationalBuilder builder) {
		this.name = builder.name;
		this.age = builder.age;
		this.addr = builder.addr;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public CreationalDemo age(String age) {
		this.age = age;
		return this;
	}

	public CreationalDemo name(String name) {
		this.name = name;
		return this;
	}

	public CreationalDemo addr(String addr) {
		this.addr = addr;
		return this;
	}
	/**
	 * 被建造目标类拥有建造者
	 * @author andreby
	 *
	 */
	public static class CreationalBuilder {

		private String name;

		private String age;

		private String addr;

		public CreationalBuilder() {
			super();
		}

		public CreationalBuilder(String name, String age, String addr) {
			super();
			this.name = name;
			this.age = age;
			this.addr = addr;
		}

		public CreationalBuilder name(String name) {
			this.name = name;
			return this;
		}

		public CreationalBuilder age(String age) {
			this.age = age;
			return this;
		}

		public CreationalBuilder addr(String addr) {
			this.addr = addr;
			return this;

		}

		public CreationalDemo build() {
			// 这里不做参数校验了
			return new CreationalDemo(this);
		}
	}

	public static void main(String[] args) {
		CreationalDemo.CreationalBuilder builder = new CreationalDemo.CreationalBuilder();
		builder.addr("123").age("123").name("454");
		CreationalDemo demo = builder.build();
	}
}
