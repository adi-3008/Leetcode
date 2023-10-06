package graph.hard;

import java.util.Arrays;

public class AllPairShortestPath {

    static final int INF = (int) 1e9;
    public static void main(String[] args) {
//        int[][] adjacencyMatrix = {
//                {0, 100, INF, INF},
//                {INF, 0, 100, 600},
//                {100, INF, 0, 200},
//                {INF, INF, INF, 0}
//        };
//        int[][] dp = AllPairShortestPathDP(4, adjacencyMatrix);
//        for(int[] it : dp)
//            System.out.println(Arrays.toString(it));

        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        };

        System.out.println(findCheapestPrice(3, flights, 0, 2, 1));
    }

    // bellmon ford
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[][] dp = new int[n][k + 2];
        for(int[] it : dp)
            Arrays.fill(it, Integer.MAX_VALUE);

        for(int i = 0; i < k + 2; i++){
            dp[src][i] = 0;
        }

        for(int i = 1; i <= k + 1; i++){
            for(int[] edge : flights){
                int u = edge[0];
                int v = edge[1];
                int cost = edge[2];

                if(dp[u][i - 1] == Integer.MAX_VALUE) continue;

                dp[v][i] = Math.min(dp[v][i], dp[u][i - 1] + cost);
            }
        }

        for(int[] it : dp)
            System.out.println(Arrays.toString(it));

        return dp[dst][k + 1] == Integer.MAX_VALUE ? -1 : dp[dst][k + 1];
    }


//    O(N^4)
    public static int[][] AllPairShortestPathDP(int n, int[][] dp){

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        if (dp[j][l] == Integer.MAX_VALUE || dp[l][k] == Integer.MAX_VALUE) continue;
                        if (dp[j][k] > dp[j][l] + dp[l][k])
                            dp[j][k] = dp[j][l] + dp[l][k];
                    }
                }
            }
        }

        return dp;
    }

    public static int[][] floydWarshall(int V, int[][] adjMatrix){
        int[][] dp = new int[V][V];

        for(int[] it : dp)
            Arrays.fill(it, (int)1e9);

        for (int i = 0; i < V; i++) {
            System.arraycopy(adjMatrix[i], 0, dp[i], 0, V);
        }

        for (int i = 0; i < V; i++) {
            for (int u = 0; u < V; u++) {
                for (int v = 0; v < V; v++) {
                    if (dp[u][v] > dp[u][i] + dp[i][v])
                        dp[u][v] = dp[u][i] + dp[i][v];
                }
            }
        }

        return dp;
    }

}
