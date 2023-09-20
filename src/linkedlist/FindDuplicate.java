package linkedlist;

// floyd hare and tortoise

public class FindDuplicate {

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        int l = length(nums, slow);

        slow = nums[0];
        int p = nums[0];

        for(int i = 0; i < l; i++){
            slow = nums[slow];
        }

        while(slow != p){
            slow = nums[slow];
            p = nums[p];
        }

        return slow;
    }

    static int length(int[] nums, int slow){
        int temp = slow;
        int l = 0;
        while(true){
            l++;
            temp = nums[temp];
            if(temp == slow) return l;
        }
    }

}
