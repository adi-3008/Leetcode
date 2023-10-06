import java.util.*;

public class Temp {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 4};
        int n = nums.length;
        int x = 2;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{nums[i], i};
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        TreeSet<Integer> treeSet = new TreeSet<>();
        int ans = Integer.MAX_VALUE;
        for(int[] pair : arr){
            int currIndex = pair[1];
            Integer floor = treeSet.floor(Math.abs(currIndex - x));
            Integer ceil = treeSet.ceiling(Math.abs(currIndex - x));
            if (floor != null)
                ans = Math.min(ans, Math.abs(nums[floor] - nums[currIndex]));
            if (ceil != null)
                ans = Math.min(ans, Math.abs(nums[ceil] - nums[currIndex]));
            treeSet.add(currIndex);
        }
        System.out.println(ans);
    }





}
