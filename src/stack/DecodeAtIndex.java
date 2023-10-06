package stack;

public class DecodeAtIndex {

    public static void main(String[] args) {
        String s = "ha2";
        int k = 4;
        System.out.println(decodeAtIndex(s, k));
    }
// haha
    public static String decodeAtIndex(String s, int k) {
        long length = 0;

        for(char ch : s.toCharArray())
            length = Character.isDigit(ch) ? length * (ch - '0') : length + 1;

        for (int j = s.length() - 1; j >= 0; j--) {
            if (Character.isDigit(s.charAt(j))) {
                length /= s.charAt(j) - '0';
                k %= length;
            } else {
                if (k == 0 || k == length) {
                    return Character.toString(s.charAt(j));
                }
                length--;
            }
        }

        return "";
    }
}
