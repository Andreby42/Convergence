package com.convergence.designpattern.stragety;

public class TransactionSuccessAction implements TransactionStragety {

	@Override
	public void doAction() {
		System.out.println("this transaction is success,do after action");
	}

}
