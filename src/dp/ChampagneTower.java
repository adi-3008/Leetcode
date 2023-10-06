package dp;

import java.util.Arrays;
//https://leetcode.com/problems/champagne-tower/
public class ChampagneTower {

    public static void main(String[] args) {
        int poured = 25;
        int query_row = 6;
        int query_column = 1;
        System.out.println(champagneTower(poured, query_row, query_column));
    }

    public static double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row + 1][query_row + 1];
        dp[0][0] = poured;
        for(int i = 0; i < query_row; i++){
            for(int j = 0; j <= i; j++){
                double rem = dp[i][j] - 1;
                if (rem < (double) 0) continue;
                dp[i + 1][j] += rem / 2;
                dp[i + 1][j + 1] += rem / 2;
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j] == (double) 1)
                    System.out.println(i + " " + j);
            }
        }

        return dp[query_row][query_glass];
    }

}
