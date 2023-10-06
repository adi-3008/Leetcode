package graph.hard;

import graph.UnionFind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalAndPseudoCriticalEdges {

    public static void main(String[] args) {
        int[][] edgeList = {
                {0, 1, 1},
                {1, 2, 1},
                {2, 3, 2},
                {0, 3, 2},
                {0, 4, 3},
                {3, 4, 3},
                {1, 4, 6}
        };
        System.out.println(findCriticalAndPseudoCriticalEdges(5, edgeList));
    }

    public static List<List<Integer>> findCriticalAndPseudoCriticalEdges(int m, int[][] edges) {
        int n = edges.length;

        int[][] edgeList = new int[n][4];

        for(int i = 0; i < n; i++){
            int[] edge = edges[i];
            edgeList[i][0] = edge[0];
            edgeList[i][1] = edge[1];
            edgeList[i][2] = edge[2];
            edgeList[i][3] = i;
        }

        Arrays.sort(edgeList, (a, b) -> Integer.compare(a[2], b[2]));

        int minWeight = 0;
        UnionFind uf = new UnionFind(m);
        for(int[] edge : edgeList){
            int u = edge[0];
            int v = edge[1];
            int edgeWeight = edge[2];
            if(uf.union(u, v))
                minWeight += edgeWeight;
        }

        List<Integer> critical = new ArrayList<>(), pseudoCritical = new ArrayList<>();


        for(int[]  edge : edgeList){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            int i = edge[3];

            // find critical edge
            uf = new UnionFind(m);
            int minWeightWithoutCurrEdge = 0;
            for(int[] it : edgeList){
                int v1 = it[0], v2 = it[1], currW = it[2], j = it[3];
                if (i == j) continue;
                if(uf.union(v1, v2))
                    minWeightWithoutCurrEdge += currW;
            }

            if(Arrays.stream(uf.rank).max().getAsInt() < m || minWeightWithoutCurrEdge > minWeight){
                critical.add(i);
                continue;
            }

            // find pseudo critical edge
            uf = new UnionFind(m);
            uf.union(u, v);
            int currWeight = w;
            for(int[] it : edgeList){
                int v1 = it[0];
                int v2 = it[1];
                if(uf.union(v1,v2))
                    currWeight += it[2];
            }

            if(currWeight == minWeight)
                pseudoCritical.add(i);
        }

        List<List<Integer>> res = new ArrayList<>();
        res.add(critical);
        res.add(pseudoCritical);
        return res;
    }
}

