package dp;

import java.util.Arrays;

//https://leetcode.com/problems/constrained-subsequence-sum/description/

public class ConstrainedSubsetSum {

    // O(N^2) TLE

    public static void main(String[] args) {
        int[] nums = {-1, -2, -3};
        int k = 1;
        System.out.println(constrainedSubsetSum(nums, k));
    }

    public static int constrainedSubsetSum(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -(int)1e9);
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, helper(nums, dp, i, k));
        }
        return max;
    }
    static int helper(int[] nums, int[] dp, int i, int k){
        if(i == nums.length)
            return 0;
        if (dp[i] != -(int)1e9)
            return dp[i];
        int maxSum = -(int)1e9;
        for(int j = i; j <= i + k - 1 && j < nums.length; j++){
            maxSum = Math.max(maxSum, nums[j]);
            maxSum = Math.max(maxSum, nums[j] + helper(nums, dp,j + 1, k));
        }
        return dp[i] = maxSum;
    }

}
