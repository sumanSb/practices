package org.selflearning.dp;

public class LCS {
    public static void main(String[] args) {
        String s1 = "SITARAM";
        String s2 = "SIYARAM";
        int[][] t = new int[s1.length()+1][s2.length()+1];
        for(int i =0;i<=s1.length();i++){
            for(int j =0;j<=s2.length();j++){
                t[i][j] = -1;
            }
        }
        int lcs = getLCS(s1,s2,s1.length(),s2.length(),t);
        System.out.println("O/P -> "+lcs);
    }

    private static int getLCS(String s1, String s2, int n1, int n2,int[][] t) {
        if(n1==0 || n2==0){
            return 0;
        }
        if(t[n1][n2] !=-1){
            return t[n1][n2];
        }
        if(s1.charAt(n1-1)==s2.charAt(n2-1)){
            return t[n1][n2] = 1+getLCS(s1,s2,n1-1,n2-1,t);
        }
        return t[n1][n2] = Math.max(getLCS(s1,s2,n1-1,n2,t),getLCS(s1,s2,n1,n2-1,t));
    }

}
