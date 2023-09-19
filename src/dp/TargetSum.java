package dp;

import java.util.Arrays;

public class TargetSum {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(findTargetSumWays(nums, target));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int[][] dp = new int[nums.length + 1][sum * 2 + 1];
        int n = nums.length;

        dp[n][target + sum] = 1;

        for(int i = n - 1; i >= 0; i--){
            for(int currSum = -sum; currSum <= sum; currSum++){
                if(dp[i + 1][currSum - nums[i] + sum] > 0) dp[i][currSum + sum] += dp[i + 1][currSum - nums[i] + sum];
                if (dp[i + 1][currSum + nums[i] + sum] > 0) dp[i][currSum + sum] += dp[i + 1][currSum + nums[i] + sum];
            }
        }

        return dp[0][target + sum];
    }

}
