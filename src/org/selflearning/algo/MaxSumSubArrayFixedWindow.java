package org.selflearning.algo;

import java.util.ArrayList;
import java.util.List;

public class MaxSumSubArrayFixedWindow {

	public static void main(String[] args) {
		// PS - From a given array, find a sub-array of given length whose sum is maximum
		int[] nums = {2,5,12,1,8,2,9,1,10};
		int wind = 3;
		int maxSum = getMaxSumOptimised(nums,wind);
		System.out.println("The max sum = "+maxSum);

	}

	private static int getMaxSum(int[] nums, int wind) {
		List<Integer> list = new ArrayList<>();
		for(int i =0;i<=nums.length-wind;i++) {
			int sum = nums[i];
			for(int j =1;j<wind;j++) {
				sum+=nums[j+i];
			}
			list.add(sum);
		}
		return list.stream().max((i,j) -> i.compareTo(j)).get();
	}
	private static int getMaxSumOptimised(int[] nums, int wind) {
		int sum = 0;
		int maxSum = 0;
		int s = wind-1;;
		while(s>=0) {
			sum+=nums[s];
			s--;
		}
		if(maxSum<sum) {
			maxSum = sum;
		}
		for(int i =0;i<nums.length-wind;i++) {
			sum+=nums[i+wind]-nums[i];
			if(maxSum<sum) {
				maxSum = sum;
			}
		}
		return maxSum;
	}

}
