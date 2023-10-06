package dp.bitmaskdp;

import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/shortest-path-visiting-all-nodes/description/

public class ShortestPathVisitingAllNode {

    public static void main(String[] args) {
        int[][] graph = {
                {1, 2, 3},
                {0},
                {0},
                {0}
        };

        System.out.println(shortestPathLength(graph));
    }

    public static int shortestPathLength(int[][] graph) {
        int n = graph.length;

        int[][] dp = new int[n][n];

        for(int[] it : dp){
            Arrays.fill(it, (int)1e9);
        }

        // pre-processing for Floyd Warshall's algorithm.
        for(int i = 0; i < n; i++){
            dp[i][i] = 0;
            for(int j = 0; j < graph[i].length; j++){
                int v = graph[i][j];
                dp[i][v] = 1;
                dp[v][i] = 1;
            }
        }

        // floyd warshall algorithm.
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    dp[j][k] = Math.min(dp[j][k], dp[j][i] + dp[i][k]);
                }
            }
        }

        int len = Integer.MAX_VALUE;
        int visit = 0;
        int[][] cache = new int[n][1 << n];

        for(int[] it : cache)
            Arrays.fill(it, (int)1e9);

        for(int i = 0; i < n; i++){
            int mask = 1 << i;
            visit |= mask;
            len = Math.min(len, calc(i, visit, n, dp, cache));
            visit ^= mask;
        }

        return len;
    }

    static int calc(int currNode, int visit, int n, int[][] dp, int[][] cache){
        if(visit == ((1 << n) - 1)) return 0;

        if(cache[currNode][visit] != (int)1e9) return cache[currNode][visit];

        int len = (int)1e9;

        for(int i = 0; i < n; i++){
            int mask = 1 << i;
            if((visit & mask) != 0) continue;
            visit |= mask;
            len = Math.min(len, dp[currNode][i] + calc(i, visit, n, dp, cache));
            visit ^= mask;
        }

        cache[currNode][visit] = len;

        return len;
    }


}
