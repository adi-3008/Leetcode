package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxScoreOfSubsequence {

    public static void main(String[] args) {
        int[] nums1 = {1, 0, 3, 2, 4};
        int[] nums2 = {2, 1, 3, 4, 5};
        System.out.println(maxScore(nums1, nums2, 3));
    }

    public static long maxScore(int[] nums1, int[] nums2, int k) {
        long maxScore = 0;
        int n = nums1.length;

        int[][] nums = new int[n][2];

        for (int i = 0; i < n; i++) {
            nums[i] = new int[]{nums2[i], nums1[i]};
        }

        Arrays.sort(nums, (a, b) -> Integer.compare(b[0], a[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long currSum = 0;
        for (int i = 0; i < n; i++) {
            currSum += nums[i][1];
            pq.add(nums[i][1]);

            if (pq.size() > k){
                int top = pq.remove();
                currSum -= top;
            }

            if (pq.size() == k)
                maxScore = Math.max(maxScore, currSum * nums[i][0]);
        }
        
        return maxScore;
    }

}
