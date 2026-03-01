package edu.grinnell.csc207.texteditor;

/**
 * A naive implementation of a text buffer using a <code>String</code>.
 */
public class SimpleStringBuffer implements Buffer {

    private String content;
    private int cursor;

    /**
     * Constructs new, empty SimpleString Buffer
     */
    public SimpleStringBuffer() {
        this.content = "";
        this.cursor = 0;
    }

    /**
     * Inserts a character where the cursor is and moves the cursor forward.
     */
    public void insert(char ch) {
        String before = content.substring(0, cursor);
        String after = content.substring(cursor);
        content = before + ch + after;
        cursor++;
    }
    
    /**
     * Deletes the character behind the cursor.
     */
    public void delete() {
        if (cursor > 0){
            String before = content.substring(0, cursor);
            String after = content.substring(cursor);
            content = before + after;
            cursor--;
        }
    }

    /**
     * @return the index of the cursor
     */
    public int getCursorPosition() {
        return this.cursor;
    }

    /**
     * Moves the cursor to the left.
     */
    public void moveLeft() {
        if (cursor > 0){
            cursor--;
        }
    }

    /**
     * Moves the cursor to the right.
     */
    public void moveRight() {
        if (cursor < content.length()){
            cursor++;
        }
    }

    /**
     * @return the number of characters in the buffer
     */
    public int getSize() {
        return content.length();
    }

    /**
     * @returns the ith character of the buffer, zero-indexed
     * @throws IndexOutOfBoundsException if i is an invalid index into the buffer.
     */
    public char getChar(int i) {
        if (i < 0 || i >= content.length()){
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return content.charAt(i);
    }

    @Override
    public String toString() {
       return this.content;
    }
}
