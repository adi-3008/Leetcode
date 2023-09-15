package slidingwindow;

import java.util.Arrays;

public class SubArraysWithKDistinctElements {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;
        System.out.println(subarraysWithKDistinct(nums, k));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        int size = Arrays.stream(nums).max().getAsInt() + 1;
        Window w1 = new Window(size);
        Window w2 = new Window(size);
        int count = 0;
        int l1 = 0, l2 = 0;

        for (int num : nums) {
            w1.add(num);
            w2.add(num);
            while (w1.countDistinct() > k) w1.remove(nums[l1++]);
            while (w2.countDistinct() >= k) w2.remove(nums[l2++]);
            count += l2 - l1;
        }

        return count;
    }
}

class Window{

    int[] frequency;
    int distinct;

    public Window(int size){
        this.frequency = new int[size];
        this.distinct = 0;
    }

    void add(int num){
        frequency[num]++;
        if(frequency[num] == 1) distinct++;
    }

    void remove(int num){
        frequency[num]--;
        if(frequency[num] == 0) distinct--;
    }

    int countDistinct(){
        return distinct;
    }
}