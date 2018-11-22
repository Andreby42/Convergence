package com.convergence.designpattern.stragety;

/**
 * 測試策略類,SPI思想也是策略類的實現
 * 
 * @author andreby
 *
 */
public class TestStragety {

	public static void main(String[] args) {
		Order order = new Order("1", 1);
		TransactionProxy transactionProxy = new TransactionProxy(order.getTransactionStatus());
		//成功的後續策略處理
		transactionProxy.doProxyProcess();
		//失敗的後續策略處理
		transactionProxy.setTransactionStatus(2);
		transactionProxy.doProxyProcess();
		//訂單正在進行中的後續處理
		transactionProxy.setTransactionStatus(3);
		transactionProxy.doProxyProcess();
	}
}
