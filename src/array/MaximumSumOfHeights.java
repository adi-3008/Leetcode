package array;

import java.util.*;

//https://leetcode.com/problems/beautiful-towers-ii/description/

public class MaximumSumOfHeights {

    public static void main(String[] args) {
        System.out.println(maximumSumOfHeightsDP(List.of(5,3,4,1,1)));
    }

//  brute force
    public static long maximumSumOfHeights(List<Integer> maxHeights) {
        long maxSum = 0;
        int n = maxHeights.size();
        for(int i = 0; i < n; i++){
            long[] heights = new long[n];
            heights[i] = maxHeights.get(i);
            for(int j = i - 1; j >= 0; j--){
                heights[j] = Math.min(heights[j + 1], maxHeights.get(j));
            }
            for(int k = i + 1; k < n; k++){
                heights[k] = Math.min(heights[k - 1], maxHeights.get(k));
            }
            maxSum = Math.max(Arrays.stream(heights).sum(), maxSum);
        }
        return maxSum;
    }


    public static long maximumSumOfHeightsOptimal(List<Integer> maxHeights) {
        int n = maxHeights.size();
        
        Stack<int[]> stack = new Stack<>();
        long[] maxSum = new long[n];
        extracted(maxHeights, n, stack, 0, maxSum, true);
        List<Integer> reverse = new ArrayList<>(maxHeights);
        Collections.reverse(reverse);
        extracted(reverse, n, new Stack<>(), 0, maxSum, false);
        long res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(maxSum[i] - maxHeights.get(i), res);
        }
        return res;
    }

    public static long maximumSumOfHeightsDP(List<Integer> maxHeights){
        long maxSum = 0;
        int n = maxHeights.size();
        int[] previousSmaller = new int[n];
        int[] nextSmaller = new int[n];
        Arrays.fill(previousSmaller, -1);
        Arrays.fill(nextSmaller, n);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int curr = maxHeights.get(i);
            while (!stack.isEmpty() && maxHeights.get(stack.peek()) > curr){
                int top = stack.pop();
                nextSmaller[top] = i;
            }
            stack.push(i);
        }
        stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            int curr = maxHeights.get(i);
            while (!stack.isEmpty() && maxHeights.get(stack.peek()) > curr){
                int top = stack.pop();
                previousSmaller[top] = i;
            }
            stack.push(i);
        }

        long[] prefix = new long[n];
        for (int i = 0; i < n; i++) {
            int curr = maxHeights.get(i);
            int prevSmaller = previousSmaller[i];
            prefix[i] = (long)(i - prevSmaller) * curr;
            if (prevSmaller >= 0)
                prefix[i] += prefix[prevSmaller];
        }

        long[] suffix = new long[n];
        for (int i = n - 1; i >= 0; i--) {
            int curr = maxHeights.get(i);
            int nxtSmaller = nextSmaller[i];
            suffix[i] = (long)(nxtSmaller - i) * curr;
            if (nxtSmaller < n )
                suffix[i] += suffix[nxtSmaller];
        }

        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, prefix[i] + suffix[i] - maxHeights.get(i));
        }

        return maxSum;
    }

    private static void extracted(List<Integer> maxHeights, int n, Stack<int[]> stack, long currSum, long[] maxSum, boolean flag) {
        for (int i = 0; i < n; i++) {
            int curr = maxHeights.get(i);
            int currCount = 0;
            while (!stack.isEmpty() && curr < maxHeights.get(stack.peek()[0])){
                int[] top = stack.pop();
                int currDiff = maxHeights.get(top[0]) - curr;
                int count = top[1];
                currSum -= (long) currDiff * count;
                currCount += count;
            }
            currCount++;
            currSum += (long)curr;
            stack.push(new int[]{i, currCount});
            if (flag) maxSum[i] += currSum;
            else maxSum[n - i - 1] += currSum;
        }
    }
}
