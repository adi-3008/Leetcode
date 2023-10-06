package dp;

import java.util.List;

public class canSplitArray {

    public static void main(String[] args) {
        List<Integer> nums = List.of(2, 3, 3, 2, 3);
        int m = 6;
        System.out.println(canSplitArray(nums, m));
    }

    public static boolean canSplitArray(List<Integer> nums, int m) {
        int n = nums.size();
        int[] prefix = new int[n];
        prefix[0] = nums.get(0);
        for(int i = 1; i < n; i++){
            prefix[i] += nums.get(i) + prefix[i - 1];
        }
        int[][] dp = new int[n][n];
        return helper(nums, prefix, dp, 0, n - 1, m, n);
    }

    static boolean helper(List<Integer> nums, int[] prefix, int[][] dp, int s, int e, int m, int n){
        if(s == e)
            return true;

        if (s > 0 || e < n - 1){
            int currSum = prefix[e];

            if (s > 0)
                currSum -= prefix[s - 1];

            if(currSum < m)
                return false;
        }

        if(dp[s][e] != 0)
            return dp[s][e] == 1;

        for(int i = s; i < e; i++){
            if(helper(nums, prefix, dp, i + 1, e, m, n) && helper(nums, prefix, dp, s, i, m, n)){
                dp[s][e] = 1;
                return true;
            }
        }

        dp[s][e] = -1;

        return false;
    }

}
