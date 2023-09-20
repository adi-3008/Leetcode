package array;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int i = -1;
        for(int j = nums.length - 2; j >= 0; j--){
            if(nums[j] < nums[j + 1]){
                i = j;
                break;
            }
        }

        if(i == -1){
            int s = 0;
            int e = nums.length - 1;
            while(s <= e){
                swap(nums, s, e);
                s++;
                e--;
            }
            return;
        }

        int min = Integer.MAX_VALUE;
        int mini = -1;

        for(int j = nums.length - 1; j > i; j--){
            if(nums[j] > nums[i] && min > nums[j]){
                min = nums[j];
                mini = j;
            }
        }

        swap(nums, i, mini);

        int s = i + 1;
        int e = nums.length - 1;

        while(s <= e){
            swap(nums, s++, e--);
        }

    }

    static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
