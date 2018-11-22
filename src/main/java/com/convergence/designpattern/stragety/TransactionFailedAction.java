package com.convergence.designpattern.stragety;
/**
 * 交易失败的处理策略类
 * @author andreby
 *
 */
public class TransactionFailedAction  implements TransactionStragety{

	@Override
	public void doAction() {
		System.out.println("this transaction is failed,do after action");
	}

}
