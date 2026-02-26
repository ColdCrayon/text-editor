package edu.grinnell.csc207.texteditor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

public class SimpleStringBufferTests {
    @Test
    public void testInsertAndCursorPosition(){
        SimpleStringBuffer buffer = new SimpleStringBuffer();
        buffer.insert('A');
        buffer.insert('V');
        buffer.insert('F');
        assertEquals("AVF", buffer.toString());
        assertEquals(3, buffer.getCursorPosition());
    }

    @Test
    public void testMove(){
        SimpleStringBuffer buffer = new SimpleStringBuffer();
        buffer.insert('A');
        buffer.insert('V');
        buffer.insert('F');
        buffer.moveLeft();
        buffer.insert('D');
        assertEquals("AVDF", buffer.toString());
    }

    @Test
    public void testDeleteAndCornerCase(){
        SimpleStringBuffer buffer = new SimpleStringBuffer();
        
        //Delete Empty Test
        buffer.delete();
        assertEquals("", buffer.toString());

        buffer.insert('G');
        buffer.delete();
        assertEquals(0, buffer.getCursorPosition());

        // Test if cursor moves left at 0
        buffer.moveLeft();
        assertEquals(0, buffer.getCursorPosition());
    }

    @Property
    boolean insertAlwaysIncreasesSize(@ForAll char c){
        SimpleStringBuffer buffer = new SimpleStringBuffer();
        int intialSize = buffer.getSize();
        buffer.insert(c);
        return buffer.getSize() == intialSize + 1;
    }
}
