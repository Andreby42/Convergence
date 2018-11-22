package com.convergence.designpattern.stragety;

import java.io.Serializable;

public class Order  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String orderId;
	
	private int transactionStatus;

	public Order(String orderId, int transactionStatus) {
		super();
		this.orderId = orderId;
		this.transactionStatus = transactionStatus;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(int transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", transactionStatus=" + transactionStatus + "]";
	}
}
