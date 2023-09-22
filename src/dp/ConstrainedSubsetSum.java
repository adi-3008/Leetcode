package dp;

import common.Pair;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/constrained-subsequence-sum/description/

public class ConstrainedSubsetSum {


    public static void main(String[] args) {
        int[] nums = {-1, -2, -3};
        int k = 1;
        System.out.println(constrainedSubsetSumTLE(nums, k));
    }

    private static int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int best = Integer.MIN_VALUE;
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.first, a.first));

        pq.add(new Pair<>(0, 1));
        for (int i = 0; i < n; i++) {
            var top = pq.remove();
            int currSum = top.first;
            int pindex = top.second;
            while (!pq.isEmpty() && i - pindex > k)
                pq.remove();
            best = Math.max(best, currSum + nums[i]);
            pq.add(new Pair<>(currSum + nums[i], i));
            pq.add(new Pair<>(0, i));
        }

        return best;

    }


    // O(N^2) TLE
    public static int constrainedSubsetSumTLE(int[] nums, int k) {
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
            maxSum = Math.max(maxSum, nums[i]);
            maxSum = Math.max(maxSum, nums[j] + helper(nums, dp,j + 1, k));
        }
        return dp[i] = maxSum;
    }

}
