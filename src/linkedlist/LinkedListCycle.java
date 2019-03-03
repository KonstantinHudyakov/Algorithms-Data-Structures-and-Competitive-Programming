package linkedlist;

public class LinkedListCycle {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        boolean add = false;
        while(fast != slow && fast != null) {
            fast = fast.next;
            if(add)
                slow = slow.next;
            add = !add;
        }
        return fast == slow;
    }
}
