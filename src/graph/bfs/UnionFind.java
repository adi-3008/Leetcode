package graph.bfs;

public class UnionFind{
    int[] parent;
    int[] rank;

    public UnionFind(int n){
        this.parent = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int v){
        while(parent[v] != v){
            parent[v] = parent[parent[v]];
            v = parent[v];
        }
        return v;
    }

    public boolean union(int v1, int v2){
        int parent1 = find(v1);
        int parent2 = find(v2);

        if(parent1 == parent2)
            return false;

        if(rank[parent1] > rank[parent2]){
            parent[parent2] = parent1;
            rank[parent1] += rank[parent2];
        }else{
            parent[parent1] = parent2;
            rank[parent2] += rank[parent1];
        }

        return true;

    }
}
