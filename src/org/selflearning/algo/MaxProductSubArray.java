package org.selflearning.algo;

import java.util.Arrays;

public class MaxProductSubArray {
	public static void main(String[] args) {
		int[] nums = {2,3,-2,4};
		int p = getMaxProd(nums);
		System.out.println("The max product sub array -> "+p);
	}
//-1,-2,-3
	private static int getMaxProd(int[] nums) {
		int max_p = Arrays.stream(nums).max().getAsInt();
		
		int curr_max =1;
		int cur_min = 1;
		int n = nums.length;
		int tmp =0;
		for(int i =0;i<n;i++) {
			if(nums[i]==0) {
				cur_min =1;
				curr_max =1;
				continue;
			}
			tmp = curr_max*nums[i];
			curr_max = Math.max(Math.max(curr_max*nums[i], cur_min*nums[i]),nums[i]);
			cur_min = Math.min(Math.min(tmp, cur_min*nums[i]),nums[i]);

			max_p = Math.max(max_p, curr_max);
		}
		
		return max_p;
	}

}
