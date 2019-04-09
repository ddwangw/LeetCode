package com.leecode.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 
 * 示例:
	给定 nums = [2, 7, 11, 15], target = 9
	因为 nums[0] + nums[1] = 2 + 7 = 9
	所以返回 [0, 1]
 * @author wangdongdong
 * 
 * 思路：
 * 
 * 	2，轮流往后进行循环，当相加的值大于选定的，调出循环
 *
 */
public class SumTwoNumber {
	//245474
	public static int[] twoSumHash(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement)) {
	            return new int[] { map.get(complement), i };
	        }
	        map.put(nums[i], i);
	    }
	    return new int[] {};
	}
	//228796
	public static int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length-1;i++) {
        	for(int j=i+1;j<nums.length;j++) {
        		if((nums[i]+nums[j])==target) {
        			return new int[]{i,j};
        		}
        	}
        }
		return new int[] {};
    }
	public static void showArrays(int[] numbers) {
		for(int i=0;i<numbers.length;i++) {
			System.out.println(numbers[i]);
		}
	}
	public static void main(String[] args) {
		int[] nums = {1, 2 , 7, 11, 15, 9, 0};
		int target = 9;
		Long startTime = System.nanoTime();
		for(int i=0;i<100000;i++) {
			twoSum(nums,target);
		}
		Long endTime = System.nanoTime();
		System.out.println(endTime-startTime);
		for(int i=0;i<100000;i++) {
			twoSumHash(nums,target);
		}
		Long end2Time = System.nanoTime();
		System.out.println(end2Time-endTime);
	}
}
