package stack;

import java.util.Stack;

//https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
//https://leetcode.com/problems/remove-duplicate-letters/
public class RemoveDuplicateLetters {

    public static void main(String[] args) {
        String s = "bbcaac";
        System.out.println(removeDuplicateLetters(s));
    }

    public static String removeDuplicateLetters(String s) {
        int n = s.length();

        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        Stack<Character> stack = new Stack<>();
        int visited = 0;

        for(int i = 0; i < n; i++){
            char curr = s.charAt(i);
            int mask = (1 << (curr - 'a'));
            while((visited & mask) == 0 && !stack.isEmpty() && stack.peek() >= curr && freq[stack.peek() - 'a'] > 1){
                char removed = stack.pop();
                int removedMask = 1 << (removed - 'a');
                visited ^= removedMask;
                freq[removed - 'a']--;
            }
            if((visited & mask) == 0){
                stack.push(curr);
                visited = visited | mask;
            }else{
                freq[curr - 'a']--;
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        sb.reverse();

        return sb.toString();
    }

}
