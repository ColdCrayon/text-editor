package edu.grinnell.csc207.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class LinkedListIntTests {
    @Test
    public void emptyListTest() {
        LinkedListInt l = new LinkedListInt();
        assertEquals(0, l.size());
    }

    @Test
    public void listAddSize10Nums() {
        LinkedListInt l = new LinkedListInt();
        for (int i = 0; i < 10; i++) {
            l.add(i);
        }
        assertEquals(10, l.size());
    }

    @Test
    public void listAddNegNums() {
        LinkedListInt l = new LinkedListInt();
        l.add(-3);
        l.add(-10);
        l.add(-22);
        assertEquals(-3, l.get(0));
        assertEquals(-10, l.get(1));
        assertEquals(-22, l.get(2));
    }

    @Test
    public void listGetSeveral() {
        LinkedListInt l = new LinkedListInt();
        int[] elements = new int[] {3, 8, 7, 2, 6, 5, 0};
        for (int i = 0; i < elements.length; i++) {
            l.add(elements[i]);
        }
        for (int i = 0; i < elements.length; i++) {
            assertEquals(elements[i], l.get(i));
        }
    }

    @Test
    public void listGetOOB() {
        LinkedListInt l = new LinkedListInt();
        l.add(3);
        l.add(2);
        l.add(7);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.get(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.get(3);
        });
    }

    @Test
    public void listRemoveSome() {
        LinkedListInt l = new LinkedListInt();
        l.add(5);
        l.add(8);
        l.add(7);
        l.add(1);
        l.add(9);
        
        assertEquals(7, l.remove(2));
        assertEquals(8, l.get(1));
        assertEquals(1, l.get(2));
        
        assertEquals(5, l.remove(0));
        assertEquals(8, l.get(0));

        assertEquals(9, l.remove(2));
        assertEquals(1, l.get(1));
    }

    @Test
    public void listRemoveOOB() {
        LinkedListInt l = new LinkedListInt();
        l.add(5);
        l.add(8);
        l.add(7);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.remove(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.remove(3);
        });
    }
}
