package dp;

//https://practice.geeksforgeeks.org/problems/maximum-sum-subsequence-of-length-k3053/1?utm_source=geeksforgeeks&utm_medium=ml_article_practice_tab&utm_campaign=article_practice_tab

import java.util.Arrays;

public class MaxSum {

    public static void main(String[] args) {
        int[] arr = {27, 7, 16, 2, 9, 6, 10, 20, 28, 10, 28, 17};
        System.out.println(max_sum(arr, 2));
    }

    public static int max_sum(int[] a, int k) {
        // Code here
        int[][] dp = new int[a.length][k + 1];
        for(int[] it : dp)
            Arrays.fill(it, -(int)1e9);
        int ans = -1;
        for (int i = 0; i < a.length; i++) {
            ans = Math.max(ans, helper(a, dp, i, k));
        }
        return ans > 0 ? ans : -1;
    }

    static int helper(int[] nums, int[][] dp, int i, int k){
        if(k == 1)
            return nums[i];

        if(i == nums.length)
            return -(int)1e9;

        if(dp[i][k] != -(int)1e9)
            return dp[i][k];

        for(int j = i + 1; j < nums.length; j++){
            if(nums[j] >= nums[i])
                dp[i][k] = Math.max(dp[i][k], nums[i] + helper(nums, dp, j, k - 1));
        }

        return dp[i][k];
    }

}
