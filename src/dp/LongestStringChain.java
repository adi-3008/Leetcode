package dp;

import java.util.Arrays;

public class LongestStringChain {

    public static void main(String[] args) {
        String[] words = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        System.out.println(longestStrChain(words));
    }

    public static int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;

        for(int i = n - 1; i >= 0; i--){
            for(int j = i + 1; j < n; j++){
                if(isPredecessor(words[i], words[j]))
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    static boolean isPredecessor(String a, String b){
        if(1 + a.length() != b.length())
            return false;

        int[] fa = new int[26];
        for(char ch : a.toCharArray()){
            fa[ch - 'a']++;
        }

        int[] fb = new int[26];
        for(int i = 0; i < b.length(); i++){
            char ch = b.charAt(i);
            fb[ch - 'a']++;
        }

        for(int i = 0; i < b.length(); i++){
            char ch = b.charAt(i);
            if (fa[ch - 'a'] != fb[ch - 'a']) return a.equals(b.substring(0, i) + b.substring(i + 1));
        }

        return false;
    }

}
