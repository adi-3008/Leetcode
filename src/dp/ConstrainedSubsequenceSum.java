package dp;

import java.util.*;

//https://leetcode.com/problems/constrained-subsequence-sum/description/

public class ConstrainedSubsequenceSum {

    // O(N^2) TLE

    public static void main(String[] args) {
        int[] nums = {-1,-2,-3};
        int k = 1;
        System.out.println(constrainedSubsetSumHeap(nums, k));
    }

    public static int constrainedSubsetSumHeap(int[] nums, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            return b[0] - a[0];
        });

        heap.add(new int[] {nums[0], 0});
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            while (i - heap.peek()[1] > k) {
                heap.remove();
            }

            int curr = Math.max(0, heap.peek()[0]) + nums[i];
            ans = Math.max(ans, curr);
            heap.add(new int[] {curr, i});
        }

        return ans;
    }

    public static int constrainedSubsetSumDeque(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> deque = new LinkedList<>();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
            if (!deque.isEmpty()) {
                dp[i] = Math.max(dp[i], nums[i] + dp[deque.peekFirst()]);
            }
            while (!deque.isEmpty() && dp[i] > dp[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static int constrainedSubsetSum(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -(int)1e9);
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, helper(nums, dp, i, k));
        }
        return max;
    }
    static int helper(int[] nums, int[] dp, int i, int k){
        if(i == nums.length)
            return 0;
        if (dp[i] != -(int)1e9)
            return dp[i];
        int maxSum = -(int)1e9;
        for(int j = i; j <= i + k - 1 && j < nums.length; j++){
            maxSum = Math.max(maxSum, nums[j]);
            maxSum = Math.max(maxSum, nums[j] + helper(nums, dp,j + 1, k));
        }
        return dp[i] = maxSum;
    }

}
