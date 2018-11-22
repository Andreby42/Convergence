package com.convergence.designpattern.stragety;
/**
 * 交易进行中的处理策略类
 * @author andreby
 *
 */
public class TransactionDoingAction implements TransactionStragety {

	@Override
	public void doAction() {
		System.out.println("this transaction is doing");
	}

}
