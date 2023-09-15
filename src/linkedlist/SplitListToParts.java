package linkedlist;

public class SplitListToParts {

    public ListNode[] splitListToParts(ListNode head, int k) {
        int l = length(head);
        ListNode[] res = new ListNode[k];
        int remNodes = l;
        for(int i = 0; i < k; i++){
            ListNode currHead = head;
            int n = (int)Math.ceil((double) remNodes /(k - i));
            remNodes -= n;
            for(int j = 0; head != null && j < n - 1; j++){
                head = head.next;
            }
            ListNode newHead = head != null ? head.next : null;
            if(head != null) head.next = null;
            head = newHead;
            res[i] = currHead;
        }
        return res;
    }

    int length(ListNode head){
        int l = 0;
        while(head != null){
            l++;
            head = head.next;
        }
        return l;
    }

}
