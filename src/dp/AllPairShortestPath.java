package dp;

import java.util.Arrays;

public class AllPairShortestPath {

    static final int INF = (int) 1e9;
    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
                {0, 100, INF, INF},
                {INF, 0, 100, 600},
                {100, INF, 0, 200},
                {INF, INF, INF, 0}
        };

        int[][] dp = floydWarshall(adjacencyMatrix.length, adjacencyMatrix);

        for(int[] it : dp)
            System.out.println(Arrays.toString(it));
    }

    public static int[][] floydWarshall(int V, int[][] adjMatrix){
        int[][] dp = new int[V][V];

        for(int[] it : dp)
            Arrays.fill(it, (int)1e9);

        for (int i = 0; i < V; i++) {
            System.arraycopy(adjMatrix[i], 0, dp[i], 0, V);
        }

        for (int i = 1; i < V; i++) {
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
