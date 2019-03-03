package linkedlist;

public class FlattenMultilevelDoublyLinkedList {
    public static void main(String[] args) {

    }

    private static class Node {
        int val;
        Node prev;
        Node next;
        Node child;

        Node() {}

        Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    public Node flatten(Node head) {
        Node save = head;
        while(head != null) {
            if(head.child != null) {
                Node temp = head.next;
                head.next = flatten(head.child);
                head.child = null;
                head.next.prev = head;
                while(head.next != null)
                    head = head.next;
                head.next = temp;
                if(temp != null)
                    temp.prev = head;
            }
            head = head.next;
        }
        return save;
    }
}


