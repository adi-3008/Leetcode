package graph.bfs;

import com.sun.source.tree.Tree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(maxSumWithK(new long[]{-4, -2, -1, -3}, 4, 2));
    }

    public static long maxSumWithK(long nums[], long n, long k) {
        long sum = Integer.MIN_VALUE;
        long[] max = new long[(int)n];
        long[] min = new long[(int)n];
        long[] prefix = new long[(int)n];
        prefix[0] = nums[0];
        max[0] = nums[0];
        min[0] = nums[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = nums[i] + prefix[i - 1];
            max[i] = Math.max(max[i - 1], prefix[i]);
            min[i] = Math.min(min[i - 1], prefix[i]);
            if (i - k >= 0){
                sum = Math.max(sum, prefix[i] >= 0 ? prefix[i] - min[i - (int)k] : prefix[i] - max[i - (int)k]);
            }
        }
        prefix[(int)n - 1] = nums[(int)n - 1];
        max[(int)n - 1] = nums[(int)n - 1];
        min[(int)n - 1] = nums[(int)n - 1];
        for (int i = (int)n - 2; i >= 0; i--) {
            prefix[i] = nums[i] + prefix[i + 1];
            max[i] = Math.max(max[i + 1], prefix[i]);
            min[i] = Math.min(min[i + 1], prefix[i]);
            if (i + k < (int)n){
                sum = Math.max(sum, prefix[i] >= 0 ? prefix[i] - min[i + (int)k] : prefix[i] - max[i + (int)k]);
            }
        }
        return sum;
    }


}



