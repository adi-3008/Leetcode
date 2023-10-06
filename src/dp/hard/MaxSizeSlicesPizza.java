package dp.hard;

//https://leetcode.com/problems/pizza-with-3n-slices/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSizeSlicesPizza {

    public static void main(String[] args) {
        int[] slices = {1,2,3,4,5,6};
        System.out.println(maxSizeSlices(slices));
        List<Long> list = new ArrayList<>(List.of(1L, 2L, 3L, 4L));
        long[] arr = list.stream().mapToLong(a -> a).toArray();
        List<Long> l = Arrays.stream(arr).boxed().toList();
        System.out.println(l);
    }

    public static int maxSizeSlices(int[] slices) {
        int n = slices.length / 3;
        return Math.max(helper(slices, 0, slices.length - 1, n), helper(slices, 1, slices.length, n));
    }

    static int helper(int[] slices, int s, int e, int n){
        int[][] dp = new int[3][n + 1];
        for (int i = e - 1; i >= s; i--) {
            for (int j = 1; j <= n; j++) {
                dp[0][j] = Math.max(dp[1][j], slices[i] + dp[2][j - 1]);
            }
            System.arraycopy(dp[1], 0, dp[2], 0, n + 1);
            System.arraycopy(dp[0], 0, dp[1], 0, n + 1);
        }
        return dp[s][n];
    }

}
