package org.selflearning.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
    static int[] t;
    public static void main(String[] args) {
        int[] nums = {90, 10,11, 22, 9, 33, 21, 50, 41, 60, 80};//
        t= new int[nums.length+1];
        Arrays.fill(t,-1);
        t[0]=1;
       // System.out.println("O/P -> " + getLIS(nums, 0, Integer.MIN_VALUE));
        //System.out.println("O/P MEMO -> " + getLISMemo(nums, 0, -1));
        System.out.println("O/P By partitioning -> " + getLISUsingList(nums));
    }

    private static int getLISUsingList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int prev = -1;
        for(int i =0;i<nums.length;i++){
            if(nums[i]>prev){
                list.add(nums[i]);

            }
            else{
                int index = partitionList(list,nums[i]);
                list.set(index,nums[i]);
            }
            prev=nums[i];
        }
        System.out.println(list);
        return list.size();
    }

    private static int partitionList(List<Integer> list, int val) {
        int l=0,r=list.size()-1;
        int mid;
        while(l<=r){
            mid = l+(r-l)/2;
            if(list.get(mid)==val){
                return mid;
            }
            else if(list.get(mid)>val){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }

    private static int getLIS(int[] nums, int i, int prev) {
        if (i == nums.length) {
            return 0;
        }
        if (nums[i] > prev) {
            return Math.max(1 + getLIS(nums, i + 1, nums[i]), getLIS(nums, i + 1, prev));
        }
        return getLIS(nums, i + 1, prev);
    }
    private static int getLISMemo(int[] nums, int i, int prev) {
        if (i == nums.length) {
            return 0;
        }
        if(t[i+1]!=-1){
            return t[i+1];
        }
        if (nums[i] > prev) {
            return t[i+1]=Math.max(1 + getLISMemo(nums, i + 1, nums[i]), getLISMemo(nums, i + 1, prev));
        }
        return t[i+1]=getLISMemo(nums, i + 1, prev);
    }
}
