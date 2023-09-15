package graph;

import java.util.PriorityQueue;

public class MinimumTime {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 3, 2},
                {5, 1, 2, 5},
                {4, 3, 8, 6}
        };
        System.out.println(minimumTime(grid));
    }

    public static int minimumTime(int[][] grid) {
        if(grid[0][1] > 1 && grid[1][0] > 1) return -1;

        int n = grid.length;
        int m = grid[0].length;

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        q.add(new int[]{0, 0, 0});
        int minTime = 0;
        int[][] directions = {
                {0, 1}, {1, 0}, {-1, 0}, {0, -1}
        };
        boolean[][] visited = new boolean[n][m];
        while(!q.isEmpty()){
            int[] top = q.remove();
            int r = top[0];
            int c = top[1];
            int t = top[2];


            visited[r][c] = true;
            if(r == n - 1 && c == m - 1) return t;
            for(int[] dir : directions){
                int dr = r + dir[0];
                int dc = c + dir[1];
                if(!isValid(n, m, dr, dc) || visited[dr][dc]) continue;
                if(t + 1 >= grid[dr][dc]) q.add(new int[]{dr, dc, t + 1});
                else {
                    int diff = grid[dr][dc] - t;
                    if(diff % 2 == 0) q.add(new int[]{dr, dc, grid[dr][dc] + 1});
                    else q.add(new int[]{dr, dc, grid[dr][dc]});
                }
            }
        }
        return -1;
    }

    static boolean isValid(int n, int m, int r, int c){
        return r >= 0 && r < n && c >= 0 && c < m;
    }

}
