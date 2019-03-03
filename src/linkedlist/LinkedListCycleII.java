package linkedlist;

import java.util.*;

public class LinkedListCycleII {
    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        Map<Integer, List<ListNode>> map = new HashMap<>();
        while(head != null) {
            if(map.containsKey(head.val)) {
                if(findInList(map.get(head.val), head))
                    return head;
                else
                    map.get(head.val).add(head);
            }
            else {
                List<ListNode> list = new ArrayList<>();
                list.add(head);
                map.put(head.val, list);
            }
            head = head.next;
        }
        return null;
    }

    private boolean findInList(List<ListNode> list, ListNode node) {
        for(ListNode temp : list)
            if(temp == node)
                return true;
        return false;
    }
}
