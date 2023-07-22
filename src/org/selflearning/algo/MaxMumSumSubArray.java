package org.selflearning.algo;

public class MaxMumSumSubArray {

	public static void main(String[] args) {
		int[] array = {  -2,-8 };
		int sum = findMaxSum(array);
		System.out.println("The Max sum of sub array = " + sum);

	}

	private static int findMaxSum(int[] array) {

		int cur_sum = 0;
		int max_sum = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			cur_sum += array[i];
			if(max_sum < cur_sum) {
				max_sum = cur_sum;
			}
			if(cur_sum<0)
				cur_sum =0;

		}
		return max_sum;

		// for arrays containing all negative numbers
		/*
		 * Arrays.sort(array);
		 * 
		 * return array[array.length-1];
		 */

	}

}
