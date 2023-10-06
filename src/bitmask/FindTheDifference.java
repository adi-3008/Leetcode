package bitmask;

//https://leetcode.com/problems/find-the-difference/description/?envType=daily-question&envId=2023-09-25
public class FindTheDifference {

    public static void main(String[] args) {
        String a = "abcd";
        String b = "abcde";
        System.out.println(findTheDifference(a, b));
    }

    public static char findTheDifference(String s, String t) {
        int r = 0;
        for (int i = 0; i < t.length(); i++) {
            r ^= t.charAt(i);
            if (i < s.length()) r ^= s.charAt(i);
        }
        return (char)r;
    }

}
