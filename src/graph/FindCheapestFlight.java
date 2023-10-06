package graph;

//https://leetcode.com/problems/cheapest-flights-within-k-stops/description/

import java.util.Arrays;

public class FindCheapestFlight {

    public static void main(String[] args) {
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 0, 100},
                {1, 3, 600}
        };
        System.out.println(findCheapestFlight(4, flights, 0, 3, 1));
    }

    public static int findCheapestFlight(int n, int[][] flights, int src, int dst, int k){
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for(int i = 0; i <= k; i++){
            int[] next = Arrays.copyOf(prices, prices.length);
            for(int[] flight : flights){
                int u = flight[0];
                int v = flight[1];
                int cost = flight[2];

                if(prices[u] == Integer.MAX_VALUE)
                    continue;

                int newCost = cost + prices[u];

                if(next[v] > newCost){
                    next[v] = newCost;
                }
            }
            prices = next;
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }

}
