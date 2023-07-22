package org.selflearning.dp;

import java.util.*;
import java.util.stream.Collectors;
//This problem is equivalent to subset sum with min diff
public class LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        int res = findWt(stones);
        System.out.println("O/P -> "+res);
    }

    private static int findWt(int[] stones) {
        int s = Arrays.stream(stones).sum();
        int n = stones.length;
        boolean[][] t = new boolean[n+1][s+1];
        for(int i =0;i<=n;i++){
            t[i][0] = true;
        }
        for(int i =1;i<=n;i++){
            for(int j =1;j<=s;j++){
                if(stones[i-1]<=j){
                    t[i][j] = t[i-1][j-stones[i-1]]||t[i-1][j];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i =0;2*i<=s;i++){
            if(t[n][i]){
                min = Math.min(min,s-2*i);
            }
        }
        return min;
    }
}
