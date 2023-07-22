package org.selflearning.algo;


// Given an integer array , find a product array such product[i] = product of all elements of array except ith element

public class ProductExceptSelf {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		int[] p = getProduct(nums);
		System.out.println("The result is ->");
		for(int i : p) {
			System.out.print(i+"\t");
		}

	}

	private static int[] getProduct(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		int p =1;
		for(int i =0;i<n;i++) {
			res[i] = p;
			p*=nums[i];
		}
		p =1;
		for(int i =n-1;i>=0;i--) {
			res[i] *= p;
			p*=nums[i];
		}
		return res;
	}

}
