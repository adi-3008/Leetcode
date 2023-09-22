package dp;

import java.util.Arrays;
//https://leetcode.com/problems/path-with-minimum-effort/?envType=daily-question&envId=2023-09-16

// Binary Search + dp + graph
public class MinimumEffortPath {

    public static void main(String[] args) {
        int[][] heights = {
                {1,10,6,7,9,10,4,9}
        };
        System.out.println(minimumEffortPath(heights));
    }

    public static int minimumEffortPath(int[][] heights) {
                int[][] directions = {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };
        int s = 0;
        int max = Arrays.stream(heights).flatMapToInt(Arrays::stream).max().getAsInt();
        int e = max;

        while (s < e){
            int mid = s + (e - s) / 2;
            if (canGetMaxDiffLessThanK(heights, directions, new boolean[heights.length][heights[0].length], new int[heights.length][heights[0].length][max + 1], 0, 0, mid)){
                e = mid;
            }else {
                s = mid + 1;
            }
        }

        return e;
    }

    private static boolean canGetMaxDiffLessThanK(int[][] heights, int[][] directions, boolean[][] visited, int[][][] dp, int r, int c, int diff) {
        if (r == heights.length - 1 && c == heights[0].length - 1)
            return true;

        if (visited[r][c])
            return false;

        if (dp[r][c][diff] != 0)
            return dp[r][c][diff] == 1;

        visited[r][c] = true;

        for(int[] dir : directions){
            int dr = r + dir[0];
            int dc = c + dir[1];
            if (!isValid(heights, dr, dc)) continue;
            int currDiff = Math.abs(heights[r][c] - heights[dr][dc]);
            if (currDiff <= diff && canGetMaxDiffLessThanK(heights, directions, visited, dp, dr, dc, diff)){
                dp[r][c][diff] = 1;
                return true;
            }
        }

        visited[r][c] = false;

        dp[r][c][diff] = -1;

        return false;

    }

    static boolean isValid(int[][] heights, int r, int c){
        return r >= 0 && r < heights.length && c >= 0 && c < heights[0].length;
    }

//   O(n^2 * (max - min))
    static int helper(int[][] heights, int[][] directions, boolean[][] visited, int r, int c, int diff){

        if(r == heights.length - 1 && c == heights[0].length - 1)
            return diff;

        if (visited[r][c])
            return (int)(1e9);

        visited[r][c] = true;

        int min = (int)(1e9);
        for(int[] dir : directions){
            int dr = dir[0] + r;
            int dc = dir[1] + c;
            if(!isValid(heights, dr, dc)) continue;
            int currDiff = Math.abs(heights[dr][dc] - heights[r][c]);
            min = Math.min(min, helper(heights, directions, visited, dr, dc, Math.max(diff, currDiff)));
        }
        visited[r][c] = false;
        return min;
    }

}
