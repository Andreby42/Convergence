package com.convergence.designpattern.stragety;

/**
 * Context角色 持有可根据交易状态码获得的交易策略类。
 * @author andreby
 *
 */
public class TransactionProxy {
	
	private int transactionStatus;
	
	public TransactionProxy(int transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public int getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(int transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	private static TransactionStragety stragety;
	
	public  void doProxyProcess() {
		if (transactionStatus == TrasactionStatusEnum.SUCCESS.status) {
			stragety = new TransactionSuccessAction();
		} else if (transactionStatus == TrasactionStatusEnum.FATILED.status) {
			stragety = new TransactionFailedAction();
		} else if (transactionStatus == TrasactionStatusEnum.DOING.status) {
			stragety = new TransactionDoingAction();
		} else {
			throw new RuntimeException("未找到具体的处理策略");
		}
		stragety.doAction();
	}

}
