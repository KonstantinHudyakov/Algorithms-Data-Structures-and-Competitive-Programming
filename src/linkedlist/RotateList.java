package linkedlist;

public class RotateList {
    public static void main(String[] args) {

    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return null;
        int len = 1;
        ListNode tail = head;
        while(tail.next != null) {
            len++;
            tail = tail.next;
        }
        if(k % len == 0)
            return head;
        k %= len;

        ListNode newTail = head;
        for(int i = 0; i < len - k - 1; i++)
            newTail = newTail.next;

        tail.next = head;
        head = newTail.next;
        newTail.next = null;
        return head;
    }
}
