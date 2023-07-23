package graph.bfs;

import java.util.*;

//https://practice.geeksforgeeks.org/contest/the-coding-cup-2-sanjivani-college-of-engineering/problems/

/**
 * 10 12 4
 * 15 20 13 1 17 9 20 13 7 7
 * 4 10
 * 1 3
 * 3 4
 * 9 10
 * 6 9
 * 7 8
 * 8 9
 * 8 9
 * 9 10
 * 7 10
 * 2 6
 * 5 10/

/**
 * 4 18 7
 * 16 14 16 7
 * 1 2
 * 2 3
 * 2 3
 * 2 4
 * 2 3
 * 1 3
 * 2 4
 * 3 4
 * 1 4
 * 3 4
 * 2 4
 * 2 4
 * 1 2
 * 1 4
 * 1 3
 * 2 4
 * 2 4
 * 1 2
 * correct answer is 23*/

public class NavigateIslandCountry {

    public static void main(String[] args) {
        System.out.println(minimumCost(3, 3, 5, new int[]{1, 2, 4}, new int[][]{
                {1, 2},
                {1, 2},
                {1, 3}
        }));
    }

    static long minimumCost(int n, int m, int x, int A[], int B[][]) {

        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int i = 1; i <= n ; i++){
            adjList.put(i, new ArrayList<>());
        }

        for(int[] edge : B){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        return -1;
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