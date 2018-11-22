package com.convergence.designpattern.stragety;

public enum TrasactionStatusEnum {
	SUCCESS(1),FATILED(2),DOING(3);
	
	public int status;

	TrasactionStatusEnum() {
	}

	private TrasactionStatusEnum(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
