package edu.grinnell.csc207.texteditor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.DisplayNameGenerator.Simple;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

public class GapBufferTests {
/**
     * Test insertions and cursor movements.
     */
    @Test
    public void testBasicOperations() {
        GapBuffer buffer = new GapBuffer();
        buffer.insert('H');
        buffer.insert('e');
        buffer.insert('l');
        buffer.insert('l');
        buffer.insert('o');
        
        assertEquals("Hello", buffer.toString());
        assertEquals(5, buffer.getCursorPosition());

        buffer.moveLeft();
        buffer.moveLeft();
        buffer.delete(); // Deletes 'l'
        
        assertEquals("Helo", buffer.toString());
        assertEquals(2, buffer.getCursorPosition());
    }
    /**
     * Test to force the array to expnd becuase of inserting the 11th char
     */

    @Test
    public void testExpansion(){
        GapBuffer buffer = new GapBuffer();
        String initial = "1234567890";
        for (char c : initial.toCharArray()) {
            buffer.insert(c);
        }
        
        buffer.insert('!');
        
        assertEquals("1234567890!", buffer.toString());
        assertEquals(11, buffer.getSize());
    }

    @Property
    void insertDeleteTest (@ForAll char c) {
        GapBuffer buffer = new GapBuffer();
        buffer.insert('s');
        String original = buffer.toString();
        
        buffer.insert(c);
        buffer.delete();
        
        assertEquals(original, buffer.toString());
    }

}
