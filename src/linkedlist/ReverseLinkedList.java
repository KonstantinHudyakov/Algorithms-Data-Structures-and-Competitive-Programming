package linkedlist;

public class ReverseLinkedList {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode curr = head;
        while(curr.next != null) {
            ListNode temp = curr.next.next;
            curr.next.next = head;
            head = curr.next;
            curr.next = temp;
        }
        return head;
    }
}
