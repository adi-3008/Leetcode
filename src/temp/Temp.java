package temp;

import graph.Pair;

import java.util.*;

public class Temp {

    public static void main(String[] args) {
//        int[] nums = {9,9,9,1,2,3};
//        System.out.println(maximumSubarraySum(nums, 3));
    }


    public static long maximumSubarraySum(int[] nums, int k) {
        long sum = 0;
        int max = Arrays.stream(nums).max().getAsInt();
        int[] frequency = new int[max + 1];
        int disctinct = 0;
        long maxSum = 0;
        for(int r = 0; r < nums.length; r++){
            sum += nums[r];
            frequency[nums[r]]++;
            if (frequency[nums[r]] == 1) disctinct++;

            if (r >= k){
                sum -= nums[r - k];
                frequency[nums[r - k]]--;
                if (frequency[nums[r - k]] == 0) disctinct--;
            }

            if (disctinct == k) maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }


}
