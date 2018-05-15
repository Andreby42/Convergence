package com.convergence.common.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StopWatch;

/**
 * 
 * @doc:
 * @author Andreby
 * @date 2018年1月25日 上午10:48:19
 */
public class TwoSum {
	/*
	 * Given an array of integers, return indices of the two numbers such that
	 * they add up to a specific target.
	 * 
	 * You may assume that each input would have exactly one solution, and you
	 * may not use the same element twice.
	 * 
	 * Example:
	 * 
	 * Given nums = [2, 7, 11, 15], target = 9,
	 * 
	 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
	 */
	/*
	 * 题意是让你从给定的数组中找到两个元素的和为指定值的两个索引，最容易的当然是循环两次， 复杂度为 O(n^2)，首次提交居然是 2ms，打败了
	 * 100% 的提交，谜一样的结果，之后再次提交就再也没跑到过 2ms 了。
	 */

	/**
	 * target=25 获得数组中两个元素相加为25的这两个元素的索引
	 */
	public static int[] arr = { 23, 5, 6, 7, 16, 9, 17, 95, 34, 2 };
	public static final int target = 25;

	public static void main(String[] args) {
		int[] twoSum_1 = twoSum_1(arr);
		if (twoSum_1 != null) {
			System.out.println(twoSum_1[0]);
			System.out.println(twoSum_1[1]);
		}
		StopWatch sw2= new StopWatch();
		sw2.start("ID2");
		int[] twoSum_2 = twoSum_2(arr, target);
		if (twoSum_2!=null) {
			System.out.println(twoSum_2[0]);
			System.out.println(twoSum_2[1]);
		}
		sw2.stop();
        System.out.println(sw2.prettyPrint());

	}

	/**
	 * 
	 * @doc:遍历循环两次 获得俩个元素值相加为target的索引数组
	 * @author Andreby
	 * @date 2018年1月25日 上午11:02:40
	 * @param args
	 * @return
	 */
	private static int[] twoSum_1(int[] arr) {
		for (int index = 0; index < arr.length; ++index) {
			for (int i = 0; i < arr.length; ++i) {
				if (arr[index] + arr[i] == target) {
					return new int[] { index, i };
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * @doc:使用map 进行 获取 map 键为target-当前元素值 value为当前元素索引
	 * @author Andreby
	 * @date 2018年1月25日 上午11:07:15
	 * @param args
	 * @return
	 */
	private static int[] twoSum_2(int[] arr, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; ++i) {
			// 如果存在当前这个 那么返回 当前i 和
			if (map.containsKey(arr[i])) {
				return new int[] { map.get(arr[i]), i };
			}
			map.put(target - arr[i], i);
		}
		return null;
	}
	
	private static int[] twoSum_3(Integer[] arr){
        List<Integer> integers = Arrays.asList(arr);
        for (int i=0; i<integers.size() ; i++) {
            int i1 = target - integers.get(i);
            if(integers.contains(i1)){
                int index = integers.indexOf(i1);
                if(index!=i){
                    System.out.println("i1="+i+",i2="+index);
                    return new int[] { i, index };
                }
            }
        }
        return null;
	}

}
