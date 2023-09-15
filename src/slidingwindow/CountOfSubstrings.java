package slidingwindow;

//https://practice.geeksforgeeks.org/problems/substrings-of-length-k-with-k-1-distinct-elements/1?utm_source=geeksforgeeks&utm_medium=ml_article_practice_tab&utm_campaign=article_practice_tab

public class CountOfSubstrings {

    static int countOfSubstrings(String s, int k) {
        // code here
        int res = 0, count = 0;
        int[] frequency = new int[26];
        for(int r = 0; r < s.length(); r++){
            char ch = s.charAt(r);
            frequency[ch - 'a']++;
            if(frequency[ch - 'a'] == 1) count++;

            if(r >= k){
                char leftChar = s.charAt(r - k);
                frequency[leftChar - 'a']--;
                if(frequency[leftChar - 'a'] == 0) count--;
            }

            if(r + 1 >= k && count == k - 1) res++;
        }
        return res;
    }

}
