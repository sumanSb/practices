package org.selflearning.dp;

import java.util.Arrays;

public class SubsetSumMinDiff {

	public static void main(String[] args) {
		int[] nums = {3,7,9,3};
		int diff = minimumDifference(nums);
		System.out.println("Min diff => "+diff);

	}
	public static int minimumDifference(int[] nums) {
        int sum =0;
        int n = nums.length;
        sum = Arrays.stream(nums).sum();
        //subset sum
        boolean[][] t = new boolean[n+1][sum+1];
        for(int i =0;i<=n;i++){
            for(int j =0;j<=sum;j++){
                if(i==0){
                    t[i][j]=false;
                }
                if(j==0){
                    t[i][j]=true;
                }
            }
        }
        for(int i =1;i<=n;i++){
            for(int j =1;j<=sum;j++){
              if(nums[i-1]<=j){
                  t[i][j] = t[i-1][j-nums[i-1]]||t[i-1][j];
              }      
              else{
                  t[i][j] = t[i-1][j];
              }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j =0;j<=sum/2;j++){
            if(t[n][j]){
               min = Math.min(min,sum-2*j);
            }
        }
        return min;
    }

}
