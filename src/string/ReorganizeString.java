package string;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ReorganizeString {

    public static void main(String[] args) {
        System.out.println(reorganizeString("aaab"));
    }

    public static String reorganizeString(String s) {
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.second, a.second));

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) pq.add(new Pair<>((char) ('a' + i), count[i]));
        }

        StringBuilder sb = new StringBuilder();
        Pair<Character, Integer> prev = null;

        while (!pq.isEmpty() || prev != null) {

            if (prev != null && pq.isEmpty())
                return "";

            var pair = pq.remove();
            char ch = pair.first;
            int cnt = --pair.second;

            sb.append(ch);

            if (prev != null) {
                pq.add(prev);
                prev = null;
            }

            if (cnt != 0) {
                prev = pair;
            }
        }

        return sb.toString();

    }

    static class Pair<A, B> {
        A first;
        B second;

        Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }
    }

}
