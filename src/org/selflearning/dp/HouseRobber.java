package org.selflearning.dp;

import java.util.Arrays;

/*You are a professional robber planning to rob houses along a street. Each house has a
certain amount of money stashed, the only constraint stopping you from robbing each of
them is that adjacent houses have security systems connected and it will automatically
contact the police if two adjacent houses were broken into on the same night.
 */
public class HouseRobber {
    private static final String MEMO="Memoization";
    private static final String REC = "Recursion";
    private static final String DP = "Bottom-up";
    private static int[] profit;

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        profit=new int[nums.length];
        Arrays.fill(profit,-1);
        int max_profit = rob(nums,REC);
        System.out.println("O/P -> "+max_profit);
    }

    private static int rob(int[] nums, String rec) {
        // recursion TOP-DOWN Approach
        // P(i) = max(n(i)+P(i-2),P(i-1)
        switch(rec){
            case REC:
                return maxProfitThroughRec(nums,nums.length-1);
            case MEMO:
                return maxProfitThroughRecMemoization(nums, nums.length);
            case DP:
                return MaxProfitThroughDP(nums,nums.length);
            default:
                return 0;
        }
    }

    private static int MaxProfitThroughDP(int[] nums, int n) {
        if(n==0){
            return 0;
        }
        if(n==1) return nums[0];
        profit[0]=nums[0];
        profit[1] = Math.max(nums[0],nums[1]);
        for(int i =2;i<n;i++){
            profit[i] = Math.max(profit[i-2]+nums[i],profit[i-1]);
        }
        return profit[n-1];
    }

    private static int maxProfitThroughRecMemoization(int[] nums, int n) {
        if(n<=0){
            return 0;
        }
        if(profit[n-1]!=-1){
            return profit[n-1];
        }
        return profit[n-1] = Math.max(nums[n-1]+maxProfitThroughRecMemoization(nums,n-2),maxProfitThroughRecMemoization(nums,n-1));

    }


    private static int maxProfitThroughRec(int[] nums, int n) {
        if(n<0){
            return 0;
        }
        return Math.max(nums[n]+maxProfitThroughRec(nums,n-2),maxProfitThroughRec(nums,n-1));
    }
}
