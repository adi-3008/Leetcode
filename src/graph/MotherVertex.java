package graph;

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/mother-vertex/1

public class MotherVertex {

    public static int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        boolean[] visited = new boolean[V];
        int motherVertex = -1;
        for(int i = 0; i < V; i++){
            if (!visited[i]) {
                dfs(i, visited, adj, V);
                motherVertex = i;
            }
        }

        visited = new boolean[V];
        count = 0;
        dfs(motherVertex, visited, adj, V);
        return count == motherVertex ? motherVertex : -1;
    }

    static int count = 0;

    static void dfs(int currNode, boolean[] visited, ArrayList<ArrayList<Integer>> adjList, int v){

        if (visited[currNode])
            return;

        visited[currNode] = true;
        count++;

        for(int nei : adjList.get(currNode)){
            dfs(nei, visited, adjList, v);
        }

    }

}
