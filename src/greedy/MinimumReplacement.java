package greedy;

//https://leetcode.com/problems/minimum-replacements-to-sort-the-array/

import java.util.Arrays;

public class MinimumReplacement {

    public static void main(String[] args) {
        int[] nums = {3, 9};
        System.out.println(minimumReplacement(nums));
    }

    public static long minimumReplacement(int[] nums) {

        long minReplacement = 0;
        int n = nums.length;
        long prev = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            long parts = (long) (Math.ceil(nums[i] / (double) prev));
            minReplacement += parts - 1;
            prev = nums[i] / parts;
        }

        return minReplacement;

    }

}
