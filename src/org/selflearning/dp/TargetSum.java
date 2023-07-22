package org.selflearning.dp;

import javax.swing.*;
import java.util.Arrays;

public class TargetSum {
   // int res=0;
    // leetcode problem
    static int total;
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3};
        int target = 6;
        total = Arrays.stream(nums).sum();
        //total = (total+target)/2;
        int[][] t = new int[nums.length][2*total+1];
        int res = findTargetSumWays(nums,0,0,target,t);
        System.out.println("Result -> "+res);
    }

    private static int findTargetSumWays(int[] a, int i,int cur_sum,int S,int[][] t) {
        if(i==a.length){
            if(cur_sum==S){
                return 1;
            }
            else return 0;
        }
        else if(t[i][cur_sum+total]!= Integer.MIN_VALUE){
            return t[i][cur_sum+total];
        }
        else{
           t[i][cur_sum+total] = findTargetSumWays(a,i+1,cur_sum+a[i],S,t) +
                   findTargetSumWays(a,i+1,cur_sum-a[i],S,t);
           return t[i][cur_sum+total];
        }

    }
}
