package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/find-the-safest-path-in-a-grid/

public class MaximumSafeNessFactor {

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int m = grid.get(0).size();
        int[][] manHattan = new int[n][m];
        for(int[] it : manHattan)
            Arrays.fill(it, (int)1e9);

        int[][] directions = {
                {0, 1},
                {1, 0},
                {-1, 0},
                {0, -1}
        };

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid.get(i).get(j) == 1){
                    q.add(new int[]{i, j});
                    manHattan[i][j] = 0;
                }
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0; s < size; s++){
                int[] top = q.remove();
                int x = top[0];
                int y = top[1];
                for(int[] dir : directions){
                    int dr = x + dir[0];
                    int dc = y + dir[1];
                    if(isValid(dr, dc, n, m) && manHattan[dr][dc] > manHattan[x][y] + 1){
                        q.add(new int[]{dr, dc});
                        manHattan[dr][dc] = 1 + manHattan[x][y];
                    }
                }
            }
        }

        int s = 0;
        int e = n + 1;
        int ans = 0;

        while(s <= e){
            int mid = s + (e - s) / 2;
            if(good(0, 0, mid, manHattan, directions, new boolean[n][m], n, m)){
                ans = mid;
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }

        return ans;
    }

    boolean good(int r, int c, int sf, int[][] manHattan, int[][] directions, boolean[][] visited, int n, int m){
        if(!isValid(r, c, n, m) || manHattan[r][c] < sf || visited[r][c])
            return false;

        if(r == n - 1 && c == m - 1) return true;

        visited[r][c] = true;

        for(int[] dir : directions){
            int dr = r + dir[0];
            int dc = c + dir[1];
            if(good(dr, dc, sf, manHattan, directions, visited, n, m)) return true;
        }

        return false;
    }

    boolean isValid(int x, int y, int n, int m){
        return x >= 0 && x < n && y >= 0 && y < m;
    }

}
