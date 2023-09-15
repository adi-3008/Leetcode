package graph;

import com.sun.source.tree.Tree;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println(numDistinct("babgbag", "bag"));
    }

    public static int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[] curr = new int[m + 1];
        int[] prev = new int[m + 1];
        prev[m] = 1;

        for (int i = s.length() - 1; i >= 0 ; i--) {
            for (int j = t.length() - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) curr[j] = prev[j];
                curr[j] += prev[j];
            }
            prev = curr;
        }
        return curr[0];
    }

    static int helper(String s, String t, int i, int j){
        if(j == t.length())
            return 1;

        if(i == s.length())
            return 0;

        int count = 0;

        if(s.charAt(i) == t.charAt(j)){
            count = helper(s, t, i + 1, j + 1);
        }

        count += helper(s, t, i + 1, j);

        return count;
    }


}



