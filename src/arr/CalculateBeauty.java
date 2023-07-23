package arr;

import java.util.*;

//https://practice.geeksforgeeks.org/contest/the-coding-cup-sanjivani-college-of-engineering/problems/#

public class CalculateBeauty {

    public static void main(String[] args) {
        System.out.println(calcBeautyLinear(new int[]{2, 4, 2}, 3));
    }

    // N^2 time solution.
    public static long calcBeauty(int[] arr, int n){
        // Code your solution here.
        long ans=0;
        for(int i = 0; i < arr.length; i++){
            HashMap<Integer, Integer> map = new HashMap<>();
            long count = 0;
            for(int j = i; j <= n-1; j++){
                if(map.containsKey(arr[j])){
                    // to avoid duplicate count.
                    if(map.get(arr[j])==1)
                        count--;
                }
                else {
                    count++;
                }
                map.put(arr[j],map.getOrDefault(arr[j], 0)+1);
                ans += count;
            }

        }
        return ans;
    }

    public static long calcBeautyLinear(int arr[], int n){
        // Code your solution here.

        HashMap<Integer, Integer> map = new HashMap<>();

        long ans = 0;

        int[] temp = new int[n];

        for(int i = 0; i < arr.length; i++){
            temp[i] = i + 1;
            if(map.containsKey(arr[i]))
                temp[i] -= map.get(arr[i]) + 1;
            map.put(arr[i], i);
        }

        map = new HashMap<>();

        for(int i = arr.length - 1; i >= 0; i--){
            long count = Math.max(1, n - i);
            if(map.containsKey(arr[i]))
                count -= n - map.get(arr[i]);
            ans += temp[i] * count;
            map.put(arr[i], i);
        }
        return ans;
    }

}
