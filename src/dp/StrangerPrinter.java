package dp;

import java.util.Arrays;

public class StrangerPrinter {

    public static void main(String[] args) {
        System.out.println(strangePrinter("aaca"));
    }

    public static int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] it : dp){
            Arrays.fill(it, n + 1);
        }
        return minTurn(s, dp, n, 0, s.length() - 1);
    }

    static int minTurn(String s, int[][] dp, int n, int l, int r){
        if(l == r)
            return 1;

        if(dp[l][r] != n + 1)
            return dp[l][r];

        int minTurn = n + 1;
        for(int i = l; i < r; i++){
            minTurn = Math.min(minTurn, minTurn(s, dp, n, l, i) + minTurn(s, dp, n, i + 1, r));
        }

        return dp[l][r] = s.charAt(l) == s.charAt(r) ? minTurn - 1 : minTurn;
    }

}
