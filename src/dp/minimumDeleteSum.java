package dp;

//https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
class minimumDeleteSum {

    public static void main(String[] args) {
        System.out.println(minimumDeleteSum("sea", "eat"));
    }
    public static int minimumDeleteSum(String s1, String s2) {
        return minAsciiSum(s1, s2, 0, 0);
    }

    static int minAsciiSum(String s1, String s2, int i, int j){

        if(i == s1.length()){
            int sum = 0;
            while(j < s2.length()){
                sum += (int)s2.charAt(j);
                j++;
            }
            return sum;
        }else if(j == s2.length()){
            int sum = 0;
            while(i < s1.length()){
                sum += (int)s1.charAt(i);
                i++;
            }
            return sum;
        }
        
        int minSum = Integer.MAX_VALUE;
        int val1 = s1.charAt(i);
        int val2 = s2.charAt(j);

        if(s1.charAt(i) == s2.charAt(j)){
            minSum = Math.min(minSum, minAsciiSum(s1, s2, i + 1, j + 1));
        }else{
            minSum = Math.min(val1 + minAsciiSum(s1, s2, i + 1, j), val2 + minAsciiSum(s1, s2, i, j + 1));
        }

        return minSum;


    }
}