package array;

public class FindPeak {

    public static void main(String[] args){
        int[] nums = {-2147483648};
        System.out.println(findPeakElement(nums));
    }

    public static int findPeakElement(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    static int helper(int[] nums, int s, int e){
        if(s > e) return -1;

        int mid = s + (e - s) / 2;

        double prev = mid - 1 < 0 ? Double.MAX_VALUE : nums[mid - 1];
        double next = mid + 1 == nums.length ? Double.MAX_VALUE : nums[mid + 1];

        if(prev < nums[mid] && nums[mid] > next) return mid;

        int left = helper(nums, s, mid - 1);
        int right = helper(nums, mid + 1, e);

        if(left != -1)
            return left;

        return right;
    }

}
