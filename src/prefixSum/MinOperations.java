package prefixSum;

import java.util.HashMap;
import java.util.Map;

public class MinOperations {

    public static void main(String[] args) {
        int[] nums = {2, 31839};
        int x = 31841;
        System.out.println(minOperationsInSpace(nums, x));
    }

    public static int minOperationsInSpace(int[] nums, int x) {
        int n = nums.length;
        int currSum = 0;
        int maxLength = -1;
        int sum = 0;
        for(int i : nums) sum += i;
        int target = sum - x;
        int l = 0;
        for(int r = 0; r < n; r++){
            currSum += nums[r];

            while(l <= r && currSum > target){
                currSum -= nums[l];
                l++;
            }

            if(currSum == target)
                maxLength = Math.max(maxLength, r - l + 1);
        }

        return maxLength == -1 ? -1 : n - maxLength;
    }

    public static int minOperations(int[] nums, int x) {
        int n = nums.length;
        Map<Integer, Integer> prefix = new HashMap<>();
        Map<Integer, Integer> suffix = new HashMap<>();

        prefix.put(0, -1);
        suffix.put(0, n);

        int prefixSum = 0;
        int suffixSum = 0;

        for(int i = 0; i < n; i++){
            prefixSum += nums[i];
            prefix.put(prefixSum, i);
            suffixSum += nums[n - i - 1];
            suffix.put(suffixSum, n - i - 1);
        }

        int minOps = n + 1;

        for(var entry : prefix.entrySet()){
            int currSum = entry.getKey();
            int curri = entry.getValue();
            int target = x - currSum;
            if(suffix.containsKey(target))
                minOps = Math.min(minOps, curri + 1 + n - suffix.get(target));
        }

        return minOps > n ? -1 : minOps;
    }

}
