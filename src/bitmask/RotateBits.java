package bitmask;

import java.util.ArrayList;
import java.util.List;

public class RotateBits {

    public static void main(String[] args) {
        int n = 11070 ;
        int d = 6909;
        System.out.println(rotate(n, d));
    }
    
    static public ArrayList<Integer> rotate(int N, int D) {
        // your code here
        D = D % 16;
        int rightMask = (((1 << D) - 1) & N) << (16 - D);
        int leftMask = (((1 << (16 - D)) - 1) & N) << D;
        int left = (N >> (16 - D)) | leftMask;
        int right = (N >> D) | rightMask;
        return new ArrayList<>(List.of(left, right));
    }

}
