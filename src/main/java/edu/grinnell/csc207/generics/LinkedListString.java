package edu.grinnell.csc207.generics;

/**
 * A linked implementation of the list ADT.
 */
public class LinkedListString {
    private static class Node {
        public String value;

        public Node next;

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node first;

    /**
     * Constructs a new, empty linked list.
     */
    public LinkedListString() {
        this.first = null;
    }

    /**
     * Adds <code>value</code> to the end of the list
     * 
     * @param value the value to add to the end of the list
     */
    public void add(String value) {
        if (first == null) {
            first = new Node(value, null);
        } else {
            Node cur = first;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(value, null);
        }
    }

    /**
     * @return the number of elements in the list
     */
    public int size() {
        int sz = 0;
        Node cur = first;
        while (cur != null) {
            sz += 1;
            cur = cur.next;
        }
        return sz;
    }

    /**
     * @param index the index of the element to retrieve
     * @return the value at the specified <code>index</code>
     */
    public String get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(index);
        }
        int origIndex = index;
        Node cur = first;
        while (index > 0 && cur != null) {
            index -= 1;
            cur = cur.next;
        }
        if (cur == null) {
            throw new IndexOutOfBoundsException(origIndex);
        } else {
            return cur.value;
        }
    }

    /**
     * Removes the value at <code>index</code> from the list
     * 
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    public String remove(int index) {
        if (index < 0 || (index == 0 && first == null)) {
            throw new IndexOutOfBoundsException(index);
        } else if (index == 0) {
            String ret = first.value;
            first = first.next;
            return ret;
        } else {
            int origIndex = index;
            Node cur = first;
            while (index > 1 && cur.next != null) {
                index -= 1;
                cur = cur.next;
            }
            if (cur.next == null) {
                throw new IndexOutOfBoundsException(origIndex);
            } else {
                String ret = cur.next.value;
                cur.next = cur.next.next;
                return ret;
            }
        }
    }
}
