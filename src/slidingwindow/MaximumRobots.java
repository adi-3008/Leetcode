package slidingwindow;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MaximumRobots {

    public static void main(String[] args) {
        int[] chargeTimes = {11,12,19};
        int[] runningCosts = {10,8,7};
        long budget = 19;
        System.out.println(maximumRobots(chargeTimes, runningCosts, budget));
    }

    public static int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int l = 0, n = chargeTimes.length, ans = 0;
        long sum = 0;
        Deque<Integer> q = new LinkedList<>();
        for(int r = 0; r < n; r++){
            sum += runningCosts[r];
            while(!q.isEmpty() && chargeTimes[q.getLast()] <= chargeTimes[r]) q.removeLast();
            q.addLast(r);

            if((chargeTimes[q.peekFirst()] + (long)(r - l + 1) * sum) > budget){
                sum -= runningCosts[l];
                if(q.peekFirst() == l) q.removeFirst();
                l++;
            }
            ans = Math.max(ans, r + l + 1);
         }
        return ans;
    }

    public int maximumRobotss(int[] times, int[] costs, long budget) {
        long sum = 0;
        int i = 0, n = times.length;
        Deque<Integer> d = new LinkedList<Integer>();
        for (int j = 0; j < n; ++j) {
            sum += costs[j];
            while (!d.isEmpty() && times[d.peekLast()] <= times[j])
                d.pollLast();
            d.addLast(j);
            if (times[d.getFirst()] + (j - i + 1) * sum > budget) {
                if (d.getFirst() == i)
                    d.pollFirst();
                sum -= costs[i++];
            }
        }
        return n - i;
    }

}
