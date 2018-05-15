package com.convergence.common.leetcode;

public class Palindrome {
	public static void main(String[] args) {
		isPalindrome(20);
	}

	public static boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		int copyX = x, reverse = 0;
		while (copyX > 0) {
			reverse = reverse * 10 + copyX % 10;
			copyX /= 10;
		}
		return x == reverse;
	}
}