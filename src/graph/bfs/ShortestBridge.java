package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/shortest-bridge/description/

// multisource shortest path

public class  ShortestBridge {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean[][] visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, visit);
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j]) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    q.add(pair);
                }
            }
        }
        return bfs(grid, q, visit);
    }

    void dfs(int[][] grid, int i, int j, boolean[][] visit) {
        if (isInValid(grid.length, i, j) || visit[i][j] || grid[i][j] == 0)
            return;
        visit[i][j] = true;
        int[][] direction = {
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };
        for (int[] dir : direction) {
            dfs(grid, i + dir[0], j + dir[1], visit);
        }
    }

    int bfs(int[][] grid, Queue<Pair<Integer, Integer>> q, boolean[][] visit) {

        int result = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Pair<Integer, Integer> currPair = q.remove();
                int sr = currPair.first;
                int sc = currPair.second;
                int[][] direction = {
                        {0, 1},
                        {0, -1},
                        {1, 0},
                        {-1, 0}
                };
                for (int[] dir : direction) {
                    int dr = sr + dir[0];
                    int dc = sc + dir[1];
                    if (isInValid(grid.length, dr, dc) || visit[dr][dc]) continue;
                    if (grid[dr][dc] == 1) return result;
                    q.add(new Pair<>(dr, dc));
                    visit[dr][dc] = true;
                }
            }
            result++;
        }
        return 0;
    }

    boolean isInValid(int n, int i, int j) {
        return i == n || j == n || i < 0 || j < 0;
    }

    public static class Pair<A, B> {
        public A first;
        public B second;
        public Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }

    }
}