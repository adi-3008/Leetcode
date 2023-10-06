package heap;

import common.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestPair {

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        System.out.println(new Pair<>(0, 0) == new Pair<>(0, 0));
        System.out.println(kSmallestPairs(nums1, nums2, 3));
    }


    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> nums1[a[0]] + nums2[a[1]]));
        pq.add(new int[]{0, 0});

        boolean[][] visited = new boolean[nums1.length][nums2.length];
        visited[0][0] = true;

        for(int i = 0; i < k; i++){
            int[] top = pq.remove();
            res.add(List.of(nums1[top[0]], nums2[top[1]]));
            if(top[0] + 1 < nums1.length && !visited[top[0] + 1][top[1]]){
                visited[top[0] + 1][top[1]] = true;
                pq.add(new int[]{top[0] + 1, top[1]});
            }
            if(top[1] + 1 < nums2.length && !visited[top[0]][top[1] + 1]){
                visited[top[0]][top[1] + 1] = true;
                pq.add(new int[]{top[0], top[1] + 1});
            }
        }
        return res;
    }

}
