package com.convergence.designpattern.adapter.class_adapter;
/**
 * 不同接口轉換器
 * @author andreby
 *
 */
public class Adaptor extends ThreeInterfaceTarget implements TwoInterfaceAdaptee {

	@Override
	public int getInterfaceType() {
		System.out.println("我是轉後的插孔接口了");
		return 3;
	}

}
