package com.leecode.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * ����֮��
 * ����һ���������� nums ��һ��Ŀ��ֵ target�������ڸ��������ҳ���ΪĿ��ֵ���� ���� ���������������ǵ������±ꡣ
 * ����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ��㲻���ظ��������������ͬ����Ԫ�ء�
 * 
 * ʾ��:
	���� nums = [2, 7, 11, 15], target = 9
	��Ϊ nums[0] + nums[1] = 2 + 7 = 9
	���Է��� [0, 1]
 * @author wangdongdong
 * 
 * ˼·��
 * 
 * 	2�������������ѭ��������ӵ�ֵ����ѡ���ģ�����ѭ��
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
