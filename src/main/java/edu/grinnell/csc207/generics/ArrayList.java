package edu.grinnell.csc207.generics;

import java.util.Arrays;

/**
 * An array-based implementation of a list, specialized to ints.
 */
public class ArrayList {

    private static final int INITIAL_SIZE = 8;

    private int[] data;

    private int sz;

    /**
     * Constructs a new, empty array list.
     */
    @SuppressWarnings("unchecked")
    public ArrayList() {
        this.data = new int[INITIAL_SIZE];
        this.sz = 0;
    }

    private void ensureCapacity() {
        if (sz == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
    }

    /**
     * Adds <code>value</code> to the end of the list
     * 
     * @param value the value to add to the end of the list
     */
    public void add(int value) {
        ensureCapacity();
        data[sz++] = value;
    }

    /**
     * @return the number of elements in the list
     */
    public int size() {
        return sz;
    }

    /**
     * @param index the index of the element to retrieve
     * @return the value at the specified <code>index</code>
     */
    public int get(int index) {
        if (index < 0 || index >= sz) {
            throw new IndexOutOfBoundsException(index);
        }
        return data[index];
    }

    /**
     * Removes the value at <code>index</code> from the list
     * 
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    public int remove(int index) {
        if (index < 0 || index >= sz) {
            throw new IndexOutOfBoundsException(index);
        } else {
            int ret = data[index];
            for (int i = index; i < data.length - 1; i++) {
                data[i] = data[i + 1];
            }
            sz -= 1;
            return ret;
        }
    }
}
