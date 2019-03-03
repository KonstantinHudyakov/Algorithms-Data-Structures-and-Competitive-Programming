package linkedlist;

public class MergeKSortedLists {
    public static void main(String[] args) {
        MergeKSortedLists obj = new MergeKSortedLists();
        ListNode fst = new ListNode(1);
        fst.next = new ListNode(4);
        fst.next.next = new ListNode(5);
        ListNode sec = new ListNode(1);
        sec.next = new ListNode(3);
        sec.next.next = new ListNode(4);
        ListNode frd = new ListNode(2);
        frd.next = new ListNode(6);

        ListNode[] lists = {fst, sec, frd};
        ListNode res = obj.mergeKLists(lists);

        while(res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode root = findMinNode(lists);
        ListNode curr = root;
        while(curr != null) {
            curr.next = findMinNode(lists);
            curr = curr.next;
        }
        return root;
    }

    private ListNode findMinNode(ListNode[] lists) {
        int minIndex = -1;
        int i = 0;
        for(; i < lists.length && minIndex == -1; i++) {
            if(lists[i] != null)
                minIndex = i;
        }
        if(minIndex == -1)
            return null;
        for(; i < lists.length; i++) {
            if(lists[i] != null && lists[i].val < lists[minIndex].val)
                minIndex = i;
        }
        ListNode res = lists[minIndex];
        lists[minIndex] = lists[minIndex].next;
        return res;
    }
}
