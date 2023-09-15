package dp;

import java.lang.reflect.Array;
import java.util.Arrays;

//https://leetcode.com/problems/interleaving-string/description/
public class InterLeavingString {

    public static void main(String[] args) {
        System.out.println(isInterleave("a", "", "c"));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int p = s3.length();

        if(n + m != p)
            return false;

        int[] dp = new int[m + 1];
        dp[m] = 1;
        for (int i = n; i >= 0; i--) {
            for (int j = m; j >= 0; j--) {
                boolean flag = (i < n && s1.charAt(i) == s3.charAt(i + j) && dp[j] == 1) ||
               (j < m && dp[j] != 1 && s2.charAt(j) == s3.charAt(i + j));
                dp[j] = flag ? 1 : 0;
            }

        }

        return dp[0] == 1;
    }

    static boolean isInterleave(String s1, String s2, String s3, int i, int j, int k){

        if(i == s1.length() && j == s2.length() && k == s3.length()) return true;

        if(k == s3.length()) return false;

        boolean canInterLeave = false;

        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)){
            canInterLeave = isInterleave(s1, s2, s3,i + 1, j, k + 1);
        }

        if(!canInterLeave && j < s2.length() && s2.charAt(j) == s3.charAt(k)){
            canInterLeave = isInterleave(s1, s2, s3, i, j + 1, k + 1);
        }

        return canInterLeave;
    }

}
