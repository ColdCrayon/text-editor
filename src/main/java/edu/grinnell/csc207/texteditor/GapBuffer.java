package edu.grinnell.csc207.texteditor;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer implements Buffer {

    private char[] data;
    private int gapStart;
    private int gapEnd;

    /**
     * Constructs an empty GapBuffer with an intial capacitu of 10
     */
    public GapBuffer() {
        this.data = new char[10];
        this.gapStart = 0;
        this.gapEnd = 10;
    }

    /**
     * Doubles the size of the backing array when the gap is full.
     * Moves the text after the gap to the end of the new, larger array.
     */
    private void expand(){
        int oldSize = data.length;
        int newSize = oldSize * 2;
        char[] newData = new char[newSize];

        for(int i = 0; i < gapStart; i++){
            newData[i] = data[i];
        }

        int afterSize = oldSize - gapEnd;
        int newGapEnd = newSize - afterSize;
        for(int i = 0; i < afterSize; i++){
            newData[newGapEnd + i] = data[gapEnd + i];
        }

        this.data = newData;
        this.gapEnd = newGapEnd;
    }

    /**
     * Inserts a character at the current cursor position
     */
    @Override
    public void insert(char ch) {
        if(gapStart == gapEnd){
            expand();
        }
        data[gapStart] = ch;
        gapStart++;
    }

    /**
     * Deletes the character to the left of the cursor
     */
    @Override
    public void delete() {
       if (gapStart > 0){
        gapStart--;
       }
    }

    /**
     * Returns the position the cursor
     */
    @Override
    public int getCursorPosition() {
        return gapStart;
    }

    /**
     * Moves the cursor one position to the left by shifting a character
     * from the left side of the gap to the right side.
     */
    @Override
    public void moveLeft() {
        if (gapStart > 0){
            data[gapEnd - 1] = data[gapStart - 1];
            gapStart--;
            gapEnd--;
        }
    }  

     /**
     * Moves the cursor one position to the right by shifting a character
     * from the right side of the gap to the left side.
     */
    @Override
    public void moveRight() {
       if (gapEnd < data.length){
           data[gapStart] = data[gapEnd];
           gapStart++;
           gapEnd++;
       }
    }

    /**
     * Returns the total number of characters in the buffer
     */
    @Override
    public int getSize() {
       int gapLength = gapEnd - gapStart;
       return data.length - gapLength;
    }

    /**
     * Returns the character at index i, jumping over the gap if necessary.
     */
    @Override
    public char getChar(int i) {
        if (i < 0 || i >= getSize()){
            throw new IndexOutOfBoundsException();
        }
        if (i < gapStart){
            return data[i];
        } else {
            int gapLength = gapEnd - gapStart;
            return data[i + gapLength];
        }
    }

    /**
     * Converts the buffer content into a String, excluding the gap.
     */
    @Override
    public String toString() {
        int actualSize = getSize();
        char[] result = new char[actualSize];

        for(int i = 0; i < gapStart; i++){
            result[i] = data[i];
        }

        int afterSize = data.length - gapEnd;
        for(int i = 0; i < afterSize; i++){
            result[gapStart + i] = data[gapEnd + i];
        }

        return new String(result);
    }
}
