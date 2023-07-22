package org.selflearning.dp;

import java.util.Arrays;

public class SubsetSumEqualK {
	static int res = 0;


	public static void main(String[] args) {
		int[] nums = {0,7,9,3,8,2,4,8,3,9};
		int k = 0;
		findTargetSumWays(nums, k);
		System.out.println("O/P -> "+res);

	}

	 public static void findTargetSumWays(int[] nums, int S) {
	       

	        //return count;
		 int n = nums.length;
		 int[][] t = new int[n+1][S+1];
		 t[0][0] = 1;
		 for(int i =1;i<=S;i++) {
			 t[0][i] =0;
		 }
		 for(int i =1;i<=n;i++) {
			 for(int j =0;j<=S;j++) {
				 if(nums[i-1]<j) {
					 t[i][j] = t[i-1][j-nums[i-1]]+t[i-1][j];
				 }
				 else {
					 t[i][j] = t[i-1][j];
				 }
			 }
		 }
		 System.out.println("Output -> "+t[n][S]);
		 //Arrays.sort(nums);
		 calculate(nums, 0, 0, S);
	    }

	private static void calculate(int[] nums, int i, int s, int t) {
		if(i==nums.length) {
			if(s==t) {
				res++;
			}
		}
		 else {
		       calculate(nums,i+1,s+nums[i],t);
		       calculate(nums,i+1,s-nums[i],t);
		}
		
	}
}
