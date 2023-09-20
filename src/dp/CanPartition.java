package dp;

import java.util.Arrays;

//https://leetcode.com/problems/partition-equal-subset-sum/

public class CanPartition {

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 == 1) return false;
        sum = sum / 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for(int i = nums.length - 1; i >= 0; i--){
            for(int s = sum / 2; s >= nums[i]; s--){
                dp[s] = dp[s] || dp[s - nums[i]];
            }
        }

        return dp[sum];
    }
}
