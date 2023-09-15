package prefixSum;

import java.util.TreeSet;

public class MaxSubArraySumNoLargerThanK {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        System.out.println(maxSumSubmatrix(matrix, 3));

    }

    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            int[] arr = new int[matrix.length];
            for (int j = i; j < matrix[0].length; j++) {
                for (int l = 0; l < matrix.length; l++) {
                    arr[l] += matrix[l][j];
                }
                ans = Math.max(ans, maxPossibleSubArrayHavingSumAtMostK(arr, k));
            }
        }

        return ans;
    }

    public static int maxPossibleSubArrayHavingSumAtMostK(int[] arr, int k){

        int prefixSum = 0;
        int ans = Integer.MIN_VALUE;
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(0);

        for (int ele : arr) {
            prefixSum += ele;
            int threshold = prefixSum - k;
            Integer ceiling = ts.ceiling(threshold);
            if (ceiling != null) {
                ans = Math.max(prefixSum - ceiling, ans);
            }
            ts.add(prefixSum);
        }

        return ans;
    }

}
