package linkedlist;

public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        int aLen = getLength(headA);
        int bLen = getLength(headB);
        if(aLen > bLen) {
            for(int i = 0; i < aLen - bLen; i++)
                headA = headA.next;
        }
        else {
            for(int i = 0; i < bLen - aLen; i++)
                headB = headB.next;
        }

        while(headA != null) {
            if(headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while(head != null) {
            head = head.next;
            length++;
        }
        return length;
    }
}
