package com.convergence.common.leetcode;/**
 * Created by LH on 2018/4/26.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StopWatch;

/**
 * @author LH
 * @desc
 * @create 2018-04-26 16:15
 **/
public class TestArray {

    public static Integer[] arr = { 23, 5, 6, 7, 16, 9, 17, 95, 34, 2 };

    public static void main(String[] args) {
        StopWatch aa = new StopWatch();
        aa.start("LH");
        tt(arr, 25);
        aa.stop();
        aa.start("WBY");
        twoSum_2(arr, 25);
        aa.stop();
        System.out.println(aa.prettyPrint());
        System.out.println(aa.getTotalTimeMillis());
        System.out.println(aa.getLastTaskName());
        System.out.println(aa.getLastTaskInfo());
        System.out.println(aa.getTaskCount());
    }

    public static int[] tt(Integer[] arr, int target) {
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

    private static int[] twoSum_2(Integer[] arr, int target) {
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

}
