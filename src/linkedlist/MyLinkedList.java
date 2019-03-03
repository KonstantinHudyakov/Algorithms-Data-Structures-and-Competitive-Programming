package linkedlist;

public class MyLinkedList {
    public static void main(String[] args) {

    }

    private static class Node {
        int val;
        Node next;
        Node prev;
        Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    private void init(Node node) {
        head = node;
        tail = node;
        if(node != null)
            size = 1;
        else
            size = 0;
    }

    /** Initialize your data structure here. */
    public MyLinkedList() {
        init(null);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= size)
            return -1;
        Node temp;
        if(index < size / 2) {
            temp = head;
            for (int i = 0; i < index; i++)
                temp = temp.next;
        }
        else {
            temp = tail;
            for (int i = 0; i < size - index - 1; i++)
                temp = temp.prev;
        }
        return temp.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if(isEmpty())
            init(new Node(val));
        else {
            Node newHead = new Node(val);
            newHead.next = head;
            head.prev = newHead;
            head = newHead;
            size++;
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(isEmpty())
            init(new Node(val));
        else {
            Node newTail = new Node(val);
            newTail.prev = tail;
            tail.next = newTail;
            tail = newTail;
            size++;
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index == 0)
            addAtHead(val);
        else if(index == size)
            addAtTail(val);
        else if(index < size) {
            Node next = head;
            for(int i = 0; i < index; i++)
                next = next.next;
            Node prev = next.prev;
            Node newNode = new Node(val);

            prev.next = newNode;
            newNode.prev = prev;
            newNode.next = next;
            next.prev = newNode;

            size++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size)
            return;
        else if(index == 0) {
            head = head.next;
            head.prev = null;
        }
        else if(index == size - 1) {
            tail = tail.prev;
            tail.next = null;
        }
        else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++)
                prev = prev.next;
            Node next = prev.next.next;

            prev.next = next;
            next.prev = prev;
        }
        size--;
        if(isEmpty())
            init(null);
    }
}
