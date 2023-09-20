package dp;

import java.util.Arrays;

public class NumberOfMusicPlaylist {

    public static void main(String[] args) {
        System.out.println(numMusicPlaylists(2, 3, 1));
    }

    static int mod;
    public static int numMusicPlaylists(int n, int goal, int k) {
        mod = (int)(1e9 + 7);
        long[][] dp = new long[n + 1][goal + 1];
        for(long[] arr : dp)
            Arrays.fill(arr, -1);
        return (int)countPlaylists(dp, n, 0, goal, k);
    }

    static long countPlaylists(long[][] dp, int n, int songsPlayed, int goal, int k){
        if(goal == 0 && songsPlayed == n){
            return 1;
        }

        if(goal < 0 || songsPlayed > n)
            return 0;

        // if(dp[songsPlayed][goal] != -1)
        //     return dp[songsPlayed][goal];

        long playLists = 0;


        playLists += (countPlaylists(dp, n, songsPlayed + 1, goal - 1, k) * (n - songsPlayed)) % mod;
        if(songsPlayed > k)
            playLists += (countPlaylists(dp, n, songsPlayed, goal - 1, k) * (songsPlayed - k) ) % mod;


        return playLists % mod;
    }

}
