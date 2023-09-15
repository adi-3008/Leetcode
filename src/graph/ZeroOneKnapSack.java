package graph;

import java.util.Arrays;

public class ZeroOneKnapSack {

    public static void main(String[] args) {
        int[] weight = {4, 5, 1};
        int[] values = {1, 2, 3};
        int w = 4;
        int n = 3;
        System.out.println(knapSack(w, weight, values, n));
    }

    static int knapSack(int w, int wt[], int val[], int n) {
        int[] dp = new int[w + 1];

        for(int i = n - 1; i >= 0; i--){
            for(int weight = w; weight >= 0; weight--){
                if(wt[i] <= weight)dp[weight] = Math.max(dp[weight], val[i] + dp[weight - wt[i]]);
                dp[weight] = Math.max(dp[weight], dp[weight]);
            }
        }

        return dp[w];
    }

}
