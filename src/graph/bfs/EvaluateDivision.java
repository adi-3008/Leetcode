package graph.bfs;

import java.util.*;

// https://leetcode.com/problems/evaluate-division/

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] ans = new double[queries.size()];

        Map<String, List<Pair<String, Double>>> adjList = buildAdjList(equations, values);

        for(int i = 0; i < ans.length; i++){
            ans[i] = bfs(adjList, queries.get(i).get(0), queries.get(i).get(1));
        }

        return ans;
    }

    public static double bfs(Map<String, List<Pair<String, Double>>> adjList, String src, String dest){
        if(adjList.get(src) == null || adjList.get(dest) == null)
            return -1.0;

        Set<String> visited = new HashSet<>();
        Queue<Pair<String, Double>> q = new LinkedList<>();
        q.add(new Pair<>(src, 1.0));


        while(!q.isEmpty()){
            int size = q.size();

            for(int s = 0; s < size; s++){

                Pair<String, Double> curr = q.remove();
                visited.add(curr.e1);

                if(dest.equals(curr.e1))
                    return curr.e2;

                for(var pair : adjList.get(curr.e1)){

                    if(!visited.contains(pair.e1)){
                        q.add(new Pair<>(pair.e1, pair.e2 * curr.e2));
                        visited.add(pair.e1);
                    }
                }

            }
        }

        return -1.0;
    }

    public static Map<String, List<Pair<String, Double>>> buildAdjList(List<List<String>> equations, double[] values){
        Map<String, List<Pair<String, Double>>> adjList = new HashMap<>();

        for(int i = 0; i < equations.size(); i++){
            String src = equations.get(i).get(0);
            String dest = equations.get(i).get(1);

            // add edge from src to dest
            List<Pair<String, Double>> list = adjList.getOrDefault(src, new ArrayList<>());
            Pair<String, Double> pair = new Pair<>(dest, values[i]);
            list.add(pair);
            adjList.put(src, list);

            // add edge from dest to src
            list = adjList.getOrDefault(dest, new ArrayList<>());
            pair = new Pair<>(src, 1 / values[i]);
            list.add(pair);
            adjList.put(dest, list);
        }

        return adjList;
    }

    public static class Pair<A, B>{
        A e1;
        B e2;

        Pair(A e1, B e2){
            this.e1 = e1;
            this.e2 = e2;
        }
    }
}

