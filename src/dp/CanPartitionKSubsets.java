package dp;

import java.util.Arrays;

public class CanPartitionKSubsets {

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,2,2,2,2};
        int k = 4;
        System.out.println(canPartitionKSubsets(nums, k));
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        int target = sum / k;
        boolean[] used = new boolean[nums.length];
        return canPartitionKSubsets(nums, 0, used, target, 0, k);
    }

    public static boolean canPartitionKSubsets(int[] nums, int i, boolean[] used, int target, int currTarget, int k){
        if (k == 0) return true;
        if (target == currTarget) return canPartitionKSubsets(nums, 0, used, target, 0, k - 1);
        for (int j = i; j < nums.length; j++) {
            if (used[i] && currTarget + nums[j] > target) continue;
            used[i] = true;
            if (canPartitionKSubsets(nums, j + 1, used, target, currTarget + nums[j], k)) return true;
            used[i] = false;
        }
        return false;
    }

    // dp + bitMasking O(N*2^N)
    public boolean canPartitionKSubsetsOptimized(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return false;

        int n = nums.length;
        //result array
        boolean[] dp = new boolean[1<<n];
        int[] total = new int[1<<n];
        dp[0] = true;

        int sum = 0;
        for(int num : nums)
            sum += num;
        Arrays.sort(nums);

        if(sum%k != 0)
            return false;
        sum /= k;
        if(nums[n-1] > sum)
            return false;
        // Loop over power set
        for(int i = 0;i < (1<<n);i++) {
            if(dp[i]) {
                // Loop over each element to find subset
                for(int j = 0;j < n;j++) {
                    // set the jth bit
                    int temp = i | (1 << j);
                    if(temp != i) {
                        // if total sum is less than target store in dp and total array
                        if(nums[j] <= (sum- (total[i]%sum))) {
                            dp[temp] = true;
                            total[temp] = nums[j] + total[i];
                        } else
                            break;
                    }
                }
            }
        }
        return dp[(1<<n) - 1];
    }

}
