package dp;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-length-of-pair-chain/description/

public class FindLongestChain {

    public static void main(String[] args) {
        int[][] pairs = {
                {1, 2},
                {2, 3},
                {3, 4}
        };
        System.out.println(findLongestChain(pairs));
    }

    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        int[] dp = new int[pairs.length];

        for (int i = 0; i < pairs.length; i++) {
            int[] pair = pairs[i];
            int len = 0;
            for (int j = pairs.length - 1; j >= 0; j--) {
                int[] nextPair = pairs[j];
                if (pair[1] < nextPair[0]) {
                    len = Math.max(len, 1 + dp[j]);
                }
            }
            dp[i] = len;
        }

        return Arrays.stream(dp).max().getAsInt() + 1;






//        Arrays.fill(dp, -1);
//
//        int len = 0;
//        for (int i = 0; i < pairs.length; i++) {
//            len = Math.max(len, helper(pairs, dp, i));
//        }
//        return 1 + len;
    }

    static int helper(int[][] pairs, int[] dp, int i) {

        if (dp[i] != -1)
            return dp[i];

        int len = 0;
        int[] currPair = pairs[i];

        for (int j = i + 1; j < pairs.length; j++) {
            int[] nextPair = pairs[j];
            if (currPair[1] < nextPair[0]) {
                len = Math.max(len, 1 + helper(pairs, dp, j));
            }
        }

        return dp[i] = len;
    }

}
