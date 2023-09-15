package graph;

import java.util.LinkedList;
import java.util.Queue;

//https://practice.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1

public class MinimumMultiplications {

    public static void main(String[] args) {
        int[] arr = {2, 5, 7};
        int s = 3;
        int e = 30;
        System.out.println(minimumMultiplications(arr, s, e));
    }

    static int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        boolean[] visited = new boolean[100000];
        int steps = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int top = q.remove();
                if (top == end) return steps;
                for (int i : arr) {
                    int newNode = (top * i) % 100000;
                    if (!visited[newNode]) {
                        visited[newNode] = true;
                        q.add(newNode);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

}
