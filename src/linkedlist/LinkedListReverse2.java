package linkedlist;

public class LinkedListReverse2 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println(reverseBetween(n1, 2, 4));
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null, curr = head;
        for(int i = 0; curr != null && i < left - 1; i++){
            prev = curr;
            curr = curr.next;
        }

        ListNode next = curr.next;
        ListNode before = prev;

        prev = null;

        ListNode newTail = curr;
        for(int i = 0; i < right - left + 1; i++){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null)
                next = next.next;
        }

        newTail.next = curr;

        if(before == null){
            head = prev;
        }else{
            before.next = prev;
        }

        return head;



    }
}
