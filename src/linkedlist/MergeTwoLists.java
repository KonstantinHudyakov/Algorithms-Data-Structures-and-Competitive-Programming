package linkedlist;

public class MergeTwoLists {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return null;
        else if(l1 == null)
            return l2;
        else if(l2 == null)
            return l1;
        ListNode head;
        if(l1.val > l2.val) {
            head = new ListNode(l2.val);
            l2 = l2.next;
        }
        else {
            head = new ListNode(l1.val);
            l1 = l1.next;
        }

        ListNode curr = head;
        while(l1 != null || l2 != null) {
            if(l1 != null && l2 != null) {
                if(l1.val > l2.val) {
                    curr.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
                else {
                    curr.next = new ListNode(l1.val);
                    l1 = l1.next;
                }
            }
            else if(l1 != null) {
                curr.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            else {
                curr.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            curr = curr.next;
        }
        return head;
    }
}
