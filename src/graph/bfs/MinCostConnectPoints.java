package graph.bfs;

import java.util.*;

public class MinCostConnectPoints {

    public static void main(String[] args) {
        int[][] points = {
                {0,0},{1, 1},{1, 0},{-1, 1}

        };
        System.out.println(minCostConnectPoints(points));
    }

    public static int minCostConnectPoints(int[][] points) {

        List<int[]> edgeList = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                edgeList.add(new int[]{i, j, manhattanDistance(points[i][0], points[i][1], points[j][0], points[j][1])});
            }
        }

        edgeList.sort(Comparator.comparingInt(a -> a[2]));

        int minWeight = 0;
        UnionFind uf = new UnionFind(points.length);
        for(int[] edge : edgeList){
            int u = edge[0];
            int v = edge[1];
            int currWeight = edge[2];
            if (uf.union(u, v))
                minWeight += currWeight;
        }
        return minWeight;
    }



    static int manhattanDistance(int i, int j, int m, int n){
        return Math.abs(i - m) + Math.abs(j - n);
    }

}
