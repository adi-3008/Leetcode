package graph;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/is-graph-bipartite/description/

public  class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int[] set = new int[graph.length];

        for(int i = 0; i < graph.length; i++){
            if(!bfs(i, set, graph))
                return false;
        }

        return true;
    }

    boolean bfs(int node, int[] set, int[][] graph){
        if(set[node] != 0)
            return true;

        Queue<Integer> q = new LinkedList<>();
        set[node] = 1;
        q.add(node);

        while(!q.isEmpty()){
            int size = q.size();

            for(int s = 0; s < size; s++){
                int currNode = q.remove();
                for(int nei : graph[currNode]){
                    if(set[currNode] == set[nei])
                        return false;
                    else if(set[nei] == 0){
                        set[nei] = -1 * set[currNode];
                        q.add(nei);
                    }
                }
            }
        }

        return true;
    }
}
