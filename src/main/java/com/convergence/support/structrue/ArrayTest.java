package com.convergence.support.structrue;

public class ArrayTest {

	private static  int [] arr = {2,3,5,78,9,9,21,245,769,22};
	
	
	//找出数组中的最大值
	public static void findBiggest(int [] arr){
		int max=Integer.MIN_VALUE;
		for (int i : arr) {
			if (i>max) {
				max= i;
			}
		}
		System.out.println("the max value of the arr is "+max);
		
	}
	public static void main(String[] args) {
		findBiggest(arr);
	}
}
