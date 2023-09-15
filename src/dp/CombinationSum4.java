package dp;

import java.util.Arrays;

public class CombinationSum4 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(combinationSum4(nums, 4));
    }


    static int helper(int[] nums, int[] dp, int target){
        if(target == 0) return 1;
        if(target < 0) return 0;
        if(dp[target] != -1) return dp[target];
        int count = 0;
        for(int i : nums){
            count += helper(nums, dp, target - i);
        }
        return dp[target] = count;
    }
    public static int combinationSum4(int[] nums, int target) {

        int[] dp = new int[target + 1];

        dp[0] = 1;
        for(int i = 0; i <= target; i++){
            for(int j : nums){
                if (i >= j) dp[i] += dp[i - j];
            }
        }
        return dp[target];


//        return helper(nums, dp, target);
    }

}
