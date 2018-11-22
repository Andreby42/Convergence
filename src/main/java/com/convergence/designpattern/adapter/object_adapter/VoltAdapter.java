package com.convergence.designpattern.adapter.object_adapter;

/**
 * 转换器
 * 
 * @author andreby
 *
 */
public class VoltAdapter implements VoltFive {
	/**
	 * 转换器需要持有要被转换的电源接口
	 */
	private Volt_220 volt_220;

	public VoltAdapter(Volt_220 volt_220) {
		this.volt_220 = volt_220;
	}

	public void setVolt_220(Volt_220 volt_220) {
		this.volt_220 = volt_220;
	}
	/**
	 * 能拿到220的电源接口
	 * @return
	 */
	public int getVolt_220() {
		return volt_220.get220V();
	}
	/**
	 * 也能拿到5v的接口
	 */
	@Override
	public int getVolt5Interface() {
		return 0;
	}

}
