package leetcode;

public class FlattenaMultilevelDoublyLinkedList {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
    public Node flatten(Node head) {
        return flatten(head, null);
    }
    private Node flatten(Node head, Node rest) {
        if (head == null)
            return rest;

        head.next = flatten(head.child, flatten(head.next, rest));
        if (head.next != null)
            head.next.prev = head;
        head.child = null;
        return head;
    }
}
