package dp;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathLength {

    public static void main(String[] args) {
        int[][] graph = {
                {1, 2, 3},
                {0},
                {0},
                {0}
        };
//        System.out.println(shortestPathLength(graph));

    }

    public static int shortestPathLength(int[][] graph) {
        int l = Integer.MAX_VALUE;
        for(int i = 0; i < graph.length; i++){
//            l = Math.min(l, bfs(graph, i, 0b111111111111));
        }
        return l;
    }

//    public static int bfs(int[][] graph, int currNode, int visited){
//        int min = 0;
//        int count = 0;
//        Queue<Integer> q = new LinkedList<>();
//        q.add(currNode);
////        boolean[] visited = new boolean[graph.length];
//        while(!q.isEmpty()){
//            int size = q.size();
//            for(int s = 0; s < size; s++){
//                int node = q.remove();
//                if (!visited[node]) count++;
//                visited[node] = true;
//                if(count == graph.length) return min;
//                for(int nei : graph[node]){
//                    q.add(nei);
//
//                }
//            }
//            min++;
//        }
//        return min;
//    }

}
