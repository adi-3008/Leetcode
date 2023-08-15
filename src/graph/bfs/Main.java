package graph.bfs;

import com.sun.source.tree.Tree;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] nums = {-1, 3, -2, 4, -5};

        int maxSum = 0;
        int currSum = 0;
        for (int num : nums) {
            currSum = Math.max(num, currSum + num);
            maxSum = Math.max(currSum, maxSum);
        }
        System.out.println(maxSum);

    }


}



