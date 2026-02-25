package edu.grinnell.csc207.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class LinkedListStringTests {
    @Test
    public void emptyListTest() {
        LinkedListString l = new LinkedListString();
        assertEquals(0, l.size());
    }

    @Test
    public void listAddSize10NumsAsStrings() {
        LinkedListString l = new LinkedListString();
        for (int i = 0; i < 10; i++) {
            l.add(Integer.toString(i));
        }
        assertEquals(10, l.size());
    }

    @Test
    public void listGetSeveral() {
        LinkedListString l = new LinkedListString();
        String[] elements = new String[] {"a", "b", "c", "d", "e", "f", "g"};
        for (int i = 0; i < elements.length; i++) {
            l.add(elements[i]);
        }
        for (int i = 0; i < elements.length; i++) {
            assertEquals(elements[i], l.get(i));
        }
    }

    @Test
    public void listGetEmpty() {
        LinkedListString l = new LinkedListString();
        l.add("");
        assertEquals("", l.get(0));
    }

    @Test
    public void listGetOOB() {
        LinkedListString l = new LinkedListString();
        l.add("hello!");
        l.add("goodbye!");
        l.add("huh?");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.get(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.get(3);
        });
    }

    @Test
    public void listRemoveSome() {
        LinkedListString l = new LinkedListString();
        l.add("!");
        l.add("@");
        l.add(".");
        l.add("#");
        l.add("&");

        // @ #
        
        assertEquals(".", l.remove(2));
        assertEquals("@", l.get(1));
        assertEquals("#", l.get(2));
        
        assertEquals("!", l.remove(0));
        assertEquals("@", l.get(0));

        assertEquals("&", l.remove(2));
        assertEquals("#", l.get(1));
    }

    @Test
    public void listRemoveOOB() {
        LinkedListString l = new LinkedListString();
        l.add("A");
        l.add("B");
        l.add("C");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.remove(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.remove(3);
        });
    }
}
