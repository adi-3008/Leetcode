package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMotherVertex {

    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        adjList.add(List.of(2, 3));
        adjList.add(List.of(0));
        adjList.add(List.of(1));
        adjList.add(List.of(4));
        adjList.add(new ArrayList<>());
        System.out.println(findMotherVertex(5, adjList));
    }

    public static int findMotherVertex(int V, List<List<Integer>> adj)
    {
        // Code here
        int motherVertex = -1;
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++){
            if (!visited[i]){
                dfs(i, visited, adj, V);
                motherVertex = i;
            }
        }
        count = 0;
        visited = new boolean[V];
        dfs(motherVertex, visited, adj, V);
        return motherVertex;
    }

    static int count = 0;

    static void dfs(int currNode, boolean[] visited, List<List<Integer>> adjList, int v){

        if (visited[currNode])
            return;

        visited[currNode] = true;
        count++;

        for(int nei : adjList.get(currNode)){
            dfs(nei, visited, adjList, v);
        }
    }

}
