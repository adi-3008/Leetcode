package string;

public class RepeatedSubStringPattern {

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abab"));
    }

    public static boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for(int i = 1; i <= n / 2; i++){
            if(n % i == 0){
                StringBuilder sb = new StringBuilder();
                int j = n / i;
                String substring = s.substring(0, i);
                sb.append(substring.repeat(Math.max(0, j)));
                if(sb.toString().equals(s))
                    return true;
            }
        }

        return false;
    }

}
