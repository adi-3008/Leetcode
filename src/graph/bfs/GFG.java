package graph.bfs;//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        // taking testcases
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            String[] starr = str.split(" ");

            // input n and d
            int n = Integer.parseInt(starr[0]);
            int m = Integer.parseInt(starr[1]);
            int x = Integer.parseInt(starr[2]);
            int[] A = new int[n];
            String str1 = br.readLine();
            String[] starr1 = str1.split(" ");

            // inserting elements in the array
            for (int j = 0; j < n; j++) {
                A[j] = Integer.parseInt(starr1[j]);
            }
            int B[][] = new int[m][2];
            for (int j = 0; j < m; j++) {
                str1 = br.readLine();
                starr1 = str1.split(" ");
                B[j][0] = Integer.parseInt(starr1[0]);
                B[j][1] = Integer.parseInt(starr1[1]);
            }
            long res = Solution.minimumCost(n, m, x, A, B);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static long minimumCost(int n, int m, int x, int A[], int B[][]) {
        // add your code here

        Map<Integer, List<Pair<Integer, Long>>> adjList = new HashMap<>();

        for(int[] edge : B){
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new Pair<>(edge[1], (long)(A[edge[0] - 1] + A[edge[1] - 1])));
            adjList.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new Pair<>(edge[0], (long)(A[edge[0] - 1] + A[edge[1] - 1])));
        }

        long ans = A[0] + A[n-1] + x;

        long[] minPath = new long[n];
        Arrays.fill(minPath, Long.MAX_VALUE);
        PriorityQueue<Pair<Integer, Long>> pq = new PriorityQueue<>((a, b) -> Double.compare(a.second, b.second));
        pq.add(new Pair<>(1, 0L));
        // Set<Integer> visited = new HashSet<>();

        while(!pq.isEmpty()){
            var edge = pq.remove();

            int currNode = edge.first;
            long currPath = edge.second;

            if(currNode == n)
                return Math.min(ans, currPath);

            for(var nei : adjList.getOrDefault(currNode, new ArrayList<>())){
                // if (visited.contains(nei.first))
                //     continue;
                long temp = currPath + nei.second;
                if(temp < minPath[nei.first - 1]){
                    minPath[nei.first - 1] = currPath + nei.second;
                    pq.add(new Pair<>(nei.first, minPath[nei.first - 1]));
                }
            }

            // visited.add(currNode);
        }

        return ans;

    }

    static class Pair<A, B>{
        A first;
        B second;

        Pair(A first, B second){
            this.first = first;
            this.second = second;
        }
    }


    
    
}
