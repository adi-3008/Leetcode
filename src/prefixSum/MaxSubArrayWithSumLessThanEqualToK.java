package prefixSum;

import java.util.TreeSet;

//https://practice.geeksforgeeks.org/problems/maximum-sum-of-subarray-less-than-or-equal-to-x4033/1?utm_source=geeksforgeeks&utm_medium=ml_article_practice_tab&utm_campaign=article_practice_tab

public class MaxSubArrayWithSumLessThanEqualToK {

    public static void main(String[] args) {
        long ans = findMaxSubarraySum(new long[]{5, 4, 2}, 3, 10);
        System.out.println(ans);
    }

    static long findMaxSubarraySum(long nums[], int n,int x)
    {
        // Your code goes here
        TreeSet<Long> ts = new TreeSet<>();
        ts.add(0L);
        long prefixSum = 0, maxSum = 0;
        for(int i = 0; i < n; i++){
            prefixSum += nums[i];
            long lowestVal = ts.first();
            if (prefixSum - lowestVal >= x)
                maxSum = Math.max(maxSum, prefixSum - lowestVal);

            long findCeil = prefixSum - x;
            ts.add(prefixSum);
        }

        return maxSum;
    }

}
