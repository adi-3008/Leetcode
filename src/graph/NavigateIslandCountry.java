package graph;

import java.util.*;

//https://practice.geeksforgeeks.org/contest/the-coding-cup-2-sanjivani-college-of-engineering/problems/

public class NavigateIslandCountry {

    public static void main(String[] args) {
        System.out.println(minimumCost(3, 3, 5, new int[]{1, 2, 4}, new int[][]{
                {1, 2},
                {1, 2},
                {1, 3}
        }));
    }

    static long minimumCost(int n, int m, int x, int A[], int B[][]) {
        // add your code here

        Map<Integer, List<Pair<Integer, Long>>> adjList = new HashMap<>();

        for(int[] edge : B){
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new Pair<>(edge[1], (long)(A[edge[0] - 1] + A[edge[1] - 1])));
            adjList.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new Pair<>(edge[0], (long)(A[edge[0] - 1] + A[edge[1] - 1])));
        }

        long ans = A[0] + A[n-1] + x;

        long[] minPath = new long[n];
        Arrays.fill(minPath, Long.MAX_VALUE);
        PriorityQueue<Pair<Integer, Long>> pq = new PriorityQueue<>((a, b) -> Double.compare(a.second, b.second));
        pq.add(new Pair<>(1, 0L));
        // Set<Integer> visited = new HashSet<>();

        while(!pq.isEmpty()){
            var edge = pq.remove();

            int currNode = edge.first;
            long currPath = edge.second;

            if(currNode == n)
                return Math.min(ans, currPath);

            for(var nei : adjList.getOrDefault(currNode, new ArrayList<>())){
                // if (visited.contains(nei.first))
                //     continue;
                long temp = currPath + nei.second;
                if(temp < minPath[nei.first - 1]){
                    minPath[nei.first - 1] = currPath + nei.second;
                    pq.add(new Pair<>(nei.first, minPath[nei.first - 1]));
                }
            }
        }

        return ans;

    }

    static class Pair<A, B>{
        A first;
        B second;

        Pair(A first, B second){
            this.first = first;
            this.second = second;
        }
    }
}