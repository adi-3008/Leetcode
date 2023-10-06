package binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxCombinations {

    public static void main(String[] args) {
//        int[] a = {371 ,349, 552, 343 ,331, 721 ,46 ,572,512, 469, 890, 608,917,719, 830 ,104, 159};
//        int[] b = {681 ,150 ,595 ,597 ,209 ,778 ,666 ,965 ,203 ,658 ,273, 404 ,389,898 ,847 ,253, 959};
//        System.out.println(maxCombinations(a.length, 6, a, b));
        List<List<Integer>> res = new ArrayList<>();
        int[] arr =  {1, 2};

    }

    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        // code here
        List<Integer> res = new ArrayList<>();
        Arrays.sort(A);
        Arrays.sort(B);

        for(int i = N - 1; i >= 0; i--){
            int curr = B[i];
            int lowerBound = 0;
            if(i > 0) lowerBound = B[i - 1] + A[N - 1];
            int b = bisect(A, lowerBound, curr);
            for(int j = N - 1; j >= b; j--){
                res.add(curr + A[j]);
                if(res.size() == K)
                    return res;
            }
        }

        return res;
    }

    static int bisect(int[] nums, int target, int curr){
        int s = 0;
        int e = nums.length - 1;
        while(s < e){
            int mid = s + (e - s) / 2;
            if(nums[mid] + curr >= target)
                e = mid;
            else
                s = mid + 1;
        }

        return s;
    }

}
