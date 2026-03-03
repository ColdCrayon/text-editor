package edu.grinnell.csc207.generics;

public class LinkedList<T> implements List<T> {
    private static class Node<U> {
        private U value;
        private Node<U> next;

        /**
         * Construct a new node with the given value
         * 
         * @param value the value
         * @param next  the next node
         */
        public Node(U value, Node<U> next) {
            this.value = value;
            this.next = null;
        }
    }

    private Node<T> first;

    public LinkedList() {
        this.first = null;
    }

    /**
     * Adds value to the end of the list
     * 
     * @param value the value to add to the end of the list
     */
    public void add(T value) {
        if (first == null) {
            first = new Node<T>(value, null);
        } else {
            Node<T> cur = first;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node<T>(value, null);
        }
    }

    /**
     * @return the number of elements in the list
     */
    public int size() {
        int sz = 0;
        Node<T> cur = first;
        while (cur != null) {
            sz += 1;
            cur = cur.next;
        }
        return sz;
    }

    /**
     * @param index the index of the element to retrieve
     * @return the value at the specified index
     */
    public T get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(index);
        }
        int origIndex = index;
        Node<T> cur = first;
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
     * Removes the value at index from the list
     * 
     * @param index the index of the element to remove
     * @return the element at index
     */
    public T remove(int index) {
        if (index < 0 || (index == 0 && first == null)) {
            throw new IndexOutOfBoundsException(index);
        } else if (index == 0) {
            T ret = first.value;
            first = first.next;
            return ret;
        } else {
            int origIndex = index;
            Node<T> cur = first;
            while (index > 1 && cur.next != null) {
                index -= 1;
                cur = cur.next;
            }
            if (cur.next == null) {
                throw new IndexOutOfBoundsException(origIndex);
            } else {
                T ret = cur.next.value;
                cur.next = cur.next.next;
                return ret;
            }
        }
    }

    /**
     * Inserts `sep` in between each element of the list
     * 
     * @param sep the value to be inserted
     */
    public void intersperse(T sep) {
        Node<T> cur = first;

        while (cur.next != null) {
            Node<T> sepNode = new Node<T>(sep, cur.next);
            cur.next = sepNode;
            cur = cur.next.next;
        }
    }

    /**
     * Returns the maximum element found in the list
     */
    public T maximum() {
        if (first.value instanceof String) {
            throw new UnsupportedOperationException();
        } else {
            T max = first.value;
            for (Node<T> cur = first.next; cur != null; cur = cur.next) {
                if (((Comparable<T>) cur.value).compareTo(max) > 0) {
                    max = cur.value;
                }
            }

            return max;
        }
    }

    /**
     * Places all element of the list into a string representation of the list.
     * of the form [x1, x2, ..., xk]
     * 
     * @return the string representation of the list
     */
    public String toString() {
        Node<T> cur = first;
        String res = "[";

        while (cur.next != null) {
            res = res + cur.value.toString() + ", ";
            cur = cur.next;
        }

        res += cur.value;

        return res + "]";
    }

    /**
     * Sorts the list using the insertion method
     */
    public void insertionSort() {
        if (first.value instanceof String) {
            throw new UnsupportedOperationException();
        } else {
            if (first == null || first.next == null) {
                return;
            }

            Node<T> sorted = null;
            Node<T> cur = first;

            while (cur != null) {
                Node<T> next = cur.next;

                if (sorted == null || ((Comparable<T>) cur.value).compareTo(sorted.value) < 0) {
                    cur.next = sorted;
                    sorted = cur;
                } else {
                    Node<T> before = sorted;
                    while (before.next != null && ((Comparable<T>) before.next.value).compareTo(cur.value) < 0) {
                        before = before.next;
                    }

                    cur.next = before.next;
                    before.next = cur;
                }

                cur = next;
            }

            first = sorted;
        }
    }
}
