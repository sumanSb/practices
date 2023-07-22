package org.selflearning.dp;

import java.util.Arrays;

public class MinCoinChangeProblem {
    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        int a = 6249;
        int min = findMinCoins(coins,a);
        System.out.println("O/P -> "+min);
        int res = findMinGreedy(coins,a);
        System.out.println("Greedy O/P -> "+res);
    }
    private static int findMinGreedy(int[] coins, int a){
        int count=0;
        Arrays.sort(coins);
        int n = coins.length;
        for(int i =1;i<=n;i++){
            while(a/coins[n-i]>0){
                count+=a/coins[n-i];
                a%=coins[n-i];
            }
        }
        if(a!=0){
            return -1;
        }
        return count;
    }

    private static int findMinCoins(int[] coins, int w) {
        int n = coins.length;

        int[][] t = new int[n+1][w+1];
        for(int i =0;i<=w;i++){
            t[0][i] = Integer.MAX_VALUE-1;
        }
        for(int i =1;i<=w;i++){
            if(i%coins[0]==0){
                t[1][i] = i/coins[0];
            }
            else {
                t[1][i] = Integer.MAX_VALUE-1;
            }
        }
        for(int i =2;i<=n;i++){
            for(int j =1;j<=w;j++){
                if(coins[i-1]<=j){
                    t[i][j] = Math.min(1+t[i][j-coins[i-1]],t[i-1][j]);
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        if(t[n][w]==Integer.MAX_VALUE-1){
            return -1;
        }
        return t[n][w];
    }
}
