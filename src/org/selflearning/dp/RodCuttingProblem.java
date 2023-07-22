package org.selflearning.dp;

public class RodCuttingProblem {
    public static void main(String[] args) {
        int[] rod = {1, 5, 8, 9, 10, 17, 17, 20};//2,4,5 (3 = 1,2,3
        int maxProfit = getMaxProfit(rod,rod.length);
        System.out.println("The max profit -> "+maxProfit);
    }

    private static int getMaxProfit(int[] rod, int n) {
        int mat[][] = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    mat[i][j] = 0;
                }
                else {
                    if (i == 1) {
                        mat[i][j] = j * rod[i - 1];
                    }
                    else {
                        if (i > j) {
                            mat[i][j] = mat[i - 1][j];
                        }
                        else {
                            mat[i][j] = Math.max(
                                    rod[i - 1]
                                            + mat[i][j - i],
                                    mat[i - 1][j]);
                        }
                    }
                }
            }
        }

        return mat[n][n];
    }

}
