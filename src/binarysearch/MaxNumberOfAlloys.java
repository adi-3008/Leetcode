package binarysearch;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/maximum-number-of-alloys/description/

public class MaxNumberOfAlloys {

    public static void main(String[] args) {
        int n = 2;
        int k = 3;
        int budget = 10;
        List<List<Integer>> composition = new ArrayList<>();
        composition.add(List.of(2, 1));
        composition.add(List.of(1, 2));
        composition.add(List.of(1, 1));
        List<Integer> stock = List.of(1, 1);
        List<Integer> cost = List.of(5, 5);
        System.out.println(maxNumberOfAlloys(n, k, budget, composition, stock, cost));
    }

    public static int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int max = 0;
        for(int i = 0; i < k; i++){
            max = Math.max(max, bs(i, budget, composition, stock, cost));
        }
        return max;
    }

    static int bs(int i, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost){
        int s = 0;
        int e = (int)1e5;
        int ans = 0;
        while (s <= e){
            int mid = s + (e - s) / 2;
            if (canMakeAlloy(i, mid, budget, composition, stock, cost)){
                ans = mid;
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        return ans;
    }

    static boolean canMakeAlloy(int i, int mid, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost){
        long totalBudget = 0;
        for(int j = 0; j < composition.get(i).size(); j++){
            totalBudget += Math.max((((long)composition.get(i).get(j) * mid) - stock.get(j)) * cost.get(j), 0);
            if (totalBudget > budget)
                return false;
        }
        return totalBudget <= budget;
    }


}
