package edu.grinnell.csc207.texteditor;

/**
 * A buffer captures the backing data structure for our text editor.
 */
public interface Buffer {
    public void insert(char ch);

    public void delete();

    public int getCursorPosition();

    public void moveLeft();

    public void moveRight();

    public int getSize();

    public char getChar(int i);

    public String toString();
}
