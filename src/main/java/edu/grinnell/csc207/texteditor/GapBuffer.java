package edu.grinnell.csc207.texteditor;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer implements Buffer {

    private char[] data;
    private int gapStart;
    private int gapEnd;

    public GapBuffer() {
        this.data = new char[10];
        this.gapStart = 0;
        this.gapEnd = 10;
    }

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

    @Override
    public void insert(char ch) {
        if(gapStart == gapEnd){
            expand();
        }
        data[gapStart] = ch;
        gapStart++;
    }

    @Override
    public void delete() {
       if (gapStart > 0){
        gapStart--;
       }
    }

    @Override
    public int getCursorPosition() {
        return gapStart;
    }

    @Override
    public void moveLeft() {
        if (gapStart > 0){
            data[gapEnd - 1] = data[gapStart - 1];
            gapStart--;
            gapEnd--;
        }
    }  

    @Override
    public void moveRight() {
       if (gapEnd < data.length){
           data[gapStart] = data[gapEnd];
           gapStart++;
           gapEnd++;
       }
    }

    @Override
    public int getSize() {
       int gapLength = gapEnd - gapStart;
       return data.length - gapLength;
    }

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
