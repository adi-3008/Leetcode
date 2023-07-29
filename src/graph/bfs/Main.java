package graph.bfs;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 5, 2};
        System.out.println(PredictTheWinner(nums));
        int val = (int)1e9 + 7;
    }

    public static boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];

        for (int[] it : dp) {
            Arrays.fill(it, -1);
        }
        int player_1 = helper(nums, dp, 0, nums.length - 1);

        int sum = 0;

        for (int it : nums) {
            sum += it;
        }
        sum -= player_1;

        return player_1 >= sum;
    }

    private static int helper(int[] nums, int[][] dp, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int left = nums[i] + Math.min(helper(nums, dp, i + 2, j), helper(nums, dp, i + 1, j - 1));
        int right = nums[j] + Math.min(helper(nums, dp, i + 1, j - 1), helper(nums, dp, i, j - 2));

        return dp[i][j] = Math.max(left, right);
    }

    public static int minSpeedOnTime(int[] dist, double hour) {
        int s = 1;
        int e = 3;

        int ans = -1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            double time = 0.0;
            for (int i = 0; i < dist.length - 1; i++) {
                double val = Math.ceil((double) dist[i] / mid);
                time += val;
            }
            time += (double) dist[dist.length - 1] / mid;
            if (time <= hour) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return ans;

    }


}