package temp;

import java.util.*;

//https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/description/
public class CountOrders {
    public static void main(String[] args) {
        System.out.println(countOrders(3));
    }

//    O(n) linear solution

    static int countOrders(int n){
        long ans = 1;
        long mod = (long)1e9 + (long)7;
        long m = 2L * n - 1;
        while (m != 1){
            ans = (ans * (m * (m + 1) / 2)) % mod;
            m -= 2;
        }
        return (int)ans;
    }


//    O(2^N) solution
    static int mod;

    public static int countOrdersTLE(int n) {
        int[] picked = new int[n];
        mod = (int)1e9 + 7;
        Map<String, Integer> dp = new HashMap<>();
        return countOrders(n, dp, picked);
    }

    static int countOrders(int n, Map<String, Integer> dp, int[] picked){
        if(n == 0) {
            return 1;
        }
        int count = 0;
        for(int i = 0; i < picked.length; i++){
            if(picked[i] == 0){
                picked[i] = 1;
                count = (count + countOrders(n, dp, picked)) % mod;
                picked[i] = 0;
            }
            else if(picked[i] == 1){
                picked[i] = -1;
                count = (count + countOrders(n - 1, dp, picked)) % mod;
                picked[i] = 1;
            }
        }
        return count;
    }
}
