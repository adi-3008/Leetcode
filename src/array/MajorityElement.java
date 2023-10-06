package array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {2,1,1,3,1,4,5,6};
        System.out.println(majorityElement(nums));
    }

    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        if(n == 1) return List.of(nums[0]);

        int e1 = 0, e2 = 0, c1 = 0, c2 = 0;

        for (int num : nums) {
            if (c1 == 0) {
                e1 = num;
                c1++;
            } else if (c2 == 0) {
                e2 = num;
                c2++;
            }else if (num == e1) {
                c1 += 1;
            } else if (num == e2) {
                c2 += 1;
            } else {
                c1--;
                c2--;
            }
        }


        int cnt1 = 0;
        int cnt2 = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == e1) cnt1++;
            if(nums[i] == e2) cnt2++;
        }

        List<Integer> list = new ArrayList<>();

        if(cnt1 > n/3) list.add(e1);
        if(e1 != e2 && cnt2 > n/3) list.add(e2);

        return list;
    }

}
