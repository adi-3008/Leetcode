package dp;

public class IsSubsequence {

    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(n == 0)return true;

        boolean[][] dp = new boolean[2][m + 1];

         for(int j = 0; j <= m; j++){
             dp[1][j] = true;
         }

        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                dp[0][j] = dp[0][j + 1];
                if(s.charAt(i) == t.charAt(j))
                    dp[0][j] = dp[0][j] || dp[1][j + 1];
            }
            System.arraycopy(dp[0], 0, dp[1], 0, m + 1);
        }

        return dp[0][0];

    }

    boolean isSubsequence(String s, String t, int i, int j){
        if(i == s.length()) return true;
        if(j == t.length()) return false;
        if(s.charAt(i) == t.charAt(j) && isSubsequence(s, t, i + 1, j + 1)) return true;
        else return isSubsequence(s, t, i, j + 1);
    }

}
