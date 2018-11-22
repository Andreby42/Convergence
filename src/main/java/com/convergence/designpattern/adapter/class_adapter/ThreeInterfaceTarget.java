package com.convergence.designpattern.adapter.class_adapter;

/**
 * 三孔插頭
 * 
 * @author andreby
 *
 */
public class ThreeInterfaceTarget {
	public int getInterfaceType() {
		System.out.println("我是個三插頭");
		return 3;
	}
}
