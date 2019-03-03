package linkedlist;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode h = new ListNode(6);
        head.next.next.next.next.next = h;
        h.next = new ListNode(7);
        h.next.next = new ListNode(8);
        h.next.next.next = new ListNode(9);

        OddEvenLinkedList obj = new OddEvenLinkedList();
        ListNode res = obj.oddEvenList(head);
    }

    public ListNode oddEvenList(ListNode head) {
        int end = 0;
        ListNode a = head;
        while(a != null) {
            end++;
            a = a.next;
        }

        for(int i = (end - 1) / 2; i > 0; i--) {
            ListNode prev = head;
            for(int j = 0; j < (end - 1) / 2 - i; j++)
                prev = prev.next;
            ListNode curr = prev.next;
            for(int j = 0; j < i; j++) {
                ListNode temp = curr.next.next;
                prev.next = curr.next;
                curr.next.next = curr;
                curr.next = temp;

                curr = curr.next;
                prev = prev.next.next;
            }
        }
        return head;
    }

    private void output(ListNode head) {
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}

//1 2 3 4 5 6 7 8 9
//1 3 2 5 4 7 6 9 8
//1 3 5 2 7 4 9 6 8
//1 3 5 7 2 9 4 6 8
//1 3 5 7 9 2 4 6 8

//1 2 3 4 5 6 7 8
//1 3 2 5 4 7 6 8
//1 3 5 2 7 4 6 8
//1 3 5 7 2 4 6 8
