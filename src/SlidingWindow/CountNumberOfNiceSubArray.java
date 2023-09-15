package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfNiceSubArray {

    public static void main(String[] args) {
        int[] arr = {1,1,2,1,1};
        System.out.println(numberOfSubArrays(arr, 3));
    }

    public static int numberOfSubArrays(int[] nums, int k) {
        int ans = 0;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            if(num % 2 == 1)
                prefixSum++;
            ans += map.getOrDefault(prefixSum - k, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return ans;
    }

}
