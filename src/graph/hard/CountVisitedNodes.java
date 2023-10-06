package graph.hard;

//https://leetcode.com/problems/count-visited-nodes-in-a-directed-graph/description/

import java.util.*;

public class CountVisitedNodes {

    public static void main(String[] args) {
        List<Integer> edges = new ArrayList<>(List.of(1, 2, 0, 0));
        System.out.println(Arrays.toString(countVisitedNodes(edges)));
    }

    public static int[] countVisitedNodes(List<Integer> edges) {
        int n = edges.size();
        int[] indegree = new int[n];
        for (int it : edges) {
            indegree[it]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (indegree[i] == 0) q.add(i);

        boolean[] vis = new boolean[n];
        List<Integer> topo = new ArrayList<>();

        while (!q.isEmpty()) {
            int curr = q.poll();
            topo.add(curr);

            vis[curr] = true;
            if (--indegree[edges.get(curr)] == 0)
                q.add(edges.get(curr));
        }

        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            List<Integer> comp = new ArrayList<>();
            getComp(i, edges, comp, vis);
            int sz = comp.size();

            for (int it : comp)
                res[it] = sz;
        }

        Collections.reverse(topo);

        for (int it : topo) {
            res[it] = 1 + res[edges.get(it)];
        }

        return res;
    }

    public static void getComp(int node, List<Integer> edges, List<Integer> comp, boolean[] vis) {
        if (vis[node]) return;
        vis[node] = true;
        comp.add(node);
        getComp(edges.get(node), edges, comp, vis);
    }

}
