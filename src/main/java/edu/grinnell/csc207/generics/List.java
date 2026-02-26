package edu.grinnell.csc207.generics;

public interface List<T> {
    /**
     * Adds value to the end of the list
     * 
     * @param value the value to add to the end of the list
     */
    public void add(T value);

    /**
     * @return the number of elements in the list
     */
    public int size();

    /**
     * @param index the index of the element to retrieve
     * @return the value at the specified index
     */
    public T get(int index);

    /**
     * Removes the value at index from the list
     * 
     * @param index the index of the element to remove
     * @return the element at index
     */
    public T remove(int index);
}
