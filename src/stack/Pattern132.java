package stack;

import java.util.*;
public class Pattern132 {

    public static void main(String[] args){
        int[] nums = {-1, 3, 2, 0};
        System.out.println(find132pattern(nums));
    }

    public static boolean find132pattern(int[] nums) {
        int n = nums.length;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{nums[0], Integer.MAX_VALUE});
        int currMin = Integer.MAX_VALUE;

        for(int i = 1; i < n; i++){
            while(!stack.isEmpty() && stack.peek()[0] <= nums[i])
                stack.pop();
            if(!stack.isEmpty() && stack.peek()[1] < nums[i]) return true;
            currMin = Math.min(currMin, nums[i - 1]);
            stack.push(new int[]{nums[i], currMin});
        }

        return false;
    }

}
