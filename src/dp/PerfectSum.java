package dp;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1?utm_source=geeksforgeeks&utm_medium=ml_article_practice_tab&utm_campaign=article_practice_tab

public class PerfectSum {

    public static void main(String[] args) {
        int[] arr = {1, 0};
        int n = 2;
        int sum = 1;
        System.out.println(perfectSumIterative(arr, n, sum));
    }

    public static int perfectSumIterative(int[] arr, int n, int sum){
        int[][] dp = new int[n + 1][sum + 1];


        dp[n][0] = 1;


        for(int i = n - 1; i >= 0; i--){
            for(int s = 0; s <= sum; s++){
                if(s >= arr[i]) dp[i][s] = (dp[i][s] + dp[i + 1][s - arr[i]]) % mod;
                dp[i][s] = (dp[i][s] + dp[i + 1][s]) % mod;
            }
        }

        return dp[0][sum];
    }

    public static int perfectSumIterativeOptimize(int[] arr, int n, int sum){
        int[] dp = new int[sum + 1];


        dp[0] = 1;

        for(int i = n - 1; i >= 0; i--){
            for(int s = sum; s >= 0; s--){
                if(s >= arr[i]) dp[s] = (dp[s] + dp[s - arr[i]]) % mod;
            }
        }

        return dp[sum];
    }

    public static int perfectSum(int[] arr, int n, int sum){
        int[][] dp = new int[n][sum + 1];

        for(int[] it : dp)
            Arrays.fill(it, -1);
        return countSubsetsWithGivenSum(arr, dp, 0, n, sum);
    }

    static int mod = (int)1e9 + 7;

    static int countSubsetsWithGivenSum(int[] arr, int[][] dp, int i, int n, int sum){

        if (i == n)
            return sum == 0 ? 1 : 0;

        if (sum < 0)
            return 0;

        if (dp[i][sum] != -1)
            return dp[i][sum];

        int count = 0;

        count = (count + countSubsetsWithGivenSum(arr, dp, i + 1, n, sum - arr[i])) % mod;
        count = (count + countSubsetsWithGivenSum(arr, dp, i + 1, n, sum)) % mod;

        return dp[i][sum] = count;
    }

}
