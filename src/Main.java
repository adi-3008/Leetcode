import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int data) {
        this.val = data;
    }
}

public class Main {
    public static void main(String[] args)  {
        int[][] graph = {
                {},
                {0, 2, 3, 4},
                {3},
                {4},
                {}
        };
        System.out.println(eventualSafeNodes(graph));
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < graph.length; i++){
            if(isSafeNode(graph, i, new boolean[graph.length]))
                ans.add(i);
        }
        return ans;
    }

    static boolean isSafeNode(int[][] graph, int curr, boolean[] visited){
        if(visited[curr])
            return false;

        visited[curr] = true;

        for(int nei : graph[curr]){
            if(!isSafeNode(graph, nei, visited))
                return false;
        }

        visited[curr] = false;

        return true;
    }



}