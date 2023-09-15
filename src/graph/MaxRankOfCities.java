package graph;

public class MaxRankOfCities {

    public static void main(String[] args) {
        int[][] roads = {
                {0, 1},
                {0, 3},
                {1, 2},
                {1, 3}
        };
        System.out.println(maximalNetworkRank(4, roads));
    }

    public static int maximalNetworkRank(int n, int[][] roads) {

        int[][] adjMatrix = new int[n][n];

        int[] outDegree = new int[n];

        for(int[] road : roads){
            int city1 = road[0];
            int city2 = road[1];
            outDegree[city1]++;
            outDegree[city2]++;
            adjMatrix[city1][city2] = 1;
            adjMatrix[city2][city1] = 1;
        }

        int maxRank = Integer.MIN_VALUE;

        for(int city1 = 0; city1 < n; city1++){
            for(int city2 = 0; city2 < n; city2++){
                if (city1 == city2) continue;
                int factor = 0;
                if(adjMatrix[city1][city2] == 1) factor = 1;
                maxRank = Math.max(maxRank, outDegree[city1] + outDegree[city2] - factor);
            }
        }

        return maxRank;
    }

}
