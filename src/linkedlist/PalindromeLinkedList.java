package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class PalindromeLinkedList {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        if(head.next.next == null) {
            if(head.val != head.next.val)
                return false;
            else
                return true;
        }
        int len = 0;
        ListNode temp = head;
        while(temp != null) {
            len++;
            temp = temp.next;
        }

        int mid;
        if(len % 2 == 0)
            mid = len / 2 + 1;
        else
            mid = len / 2 + 2;

        ListNode middle = head;
        for(int i = 1; i < mid; i++)
            middle = middle.next;
        middle = reverseList(middle);

        while(middle != null) {
            if(middle.val != head.val)
                return false;
            middle = middle.next;
            head = head.next;
        }
        return true;
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
