package linkedlist;

public class AddTwoNumbers {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(0);
        ListNode curr = fakeHead;
        int addition = 0;
        while(l1 != null && l2 != null) {
            curr.next = new ListNode((l1.val + l2.val + addition) % 10);
            addition = (l1.val + l2.val + addition) / 10;
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            curr.next = new ListNode((l1.val + addition) % 10);
            addition = (l1.val + addition) / 10;
            curr = curr.next;
            l1 = l1.next;
        }
        while(l2 != null) {
            curr.next = new ListNode((l2.val + addition) % 10);
            addition = (l2.val + addition) / 10;
            curr = curr.next;
            l2 = l2.next;
        }
        if(addition == 1)
            curr.next = new ListNode(1);

        return fakeHead.next;
    }
}
