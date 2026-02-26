package edu.grinnell.csc207.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ListTest {
    @Test
    public void emptyLinkedListTest() {
        List<Integer> l = new LinkedList<Integer>();
        assertEquals(0, l.size());
    }

    @Test
    public void linkedListAddSize10Nums() {
        List<Integer> l = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            l.add(i);
        }
        assertEquals(10, l.size());
    }

    @Test
    public void linkedListAddNegNums() {
        List<Integer> l = new LinkedList<Integer>();
        l.add(-3);
        l.add(-10);
        l.add(-22);
        assertEquals(-3, l.get(0));
        assertEquals(-10, l.get(1));
        assertEquals(-22, l.get(2));
    }

    @Test
    public void linkedListGetSeveral() {
        List<Integer> l = new LinkedList<Integer>();
        int[] elements = new int[] { 3, 8, 7, 2, 6, 5, 0 };
        for (int i = 0; i < elements.length; i++) {
            l.add(elements[i]);
        }
        for (int i = 0; i < elements.length; i++) {
            assertEquals(elements[i], l.get(i));
        }
    }

    @Test
    public void linkedListGetOOB() {
        List<Integer> l = new LinkedList<Integer>();
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
    public void linkedListRemoveSome() {
        List<Integer> l = new LinkedList<Integer>();
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
    public void linkedListRemoveOOB() {
        List<Integer> l = new LinkedList<Integer>();
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

    @Test
    public void linkedLististGetSeveralStrings() {
        List<String> l = new LinkedList<String>();
        String[] elements = new String[] { "a", "b", "c", "d", "e", "f", "g" };
        for (int i = 0; i < elements.length; i++) {
            l.add(elements[i]);
        }
        for (int i = 0; i < elements.length; i++) {
            assertEquals(elements[i], l.get(i));
        }
    }

    @Test
    public void emptyListTest() {
        List<Integer> l = new ArrayList<Integer>();
        assertEquals(0, l.size());
    }

    @Test
    public void listAddSize10Nums() {
        List<Integer> l = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            l.add(i);
        }
        assertEquals(10, l.size());
    }

    @Test
    public void listAddNegNums() {
        List<Integer> l = new ArrayList<Integer>();
        l.add(-3);
        l.add(-10);
        l.add(-22);
        assertEquals(-3, l.get(0));
        assertEquals(-10, l.get(1));
        assertEquals(-22, l.get(2));
    }

    @Test
    public void listGetSeveral() {
        List<Integer> l = new ArrayList<Integer>();
        int[] elements = new int[] { 3, 8, 7, 2, 6, 5, 0 };
        for (int i = 0; i < elements.length; i++) {
            l.add(elements[i]);
        }
        for (int i = 0; i < elements.length; i++) {
            assertEquals(elements[i], l.get(i));
        }
    }

    @Test
    public void listGetOOB() {
        List<Integer> l = new ArrayList<Integer>();
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
        List<Integer> l = new ArrayList<Integer>();
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
        List<Integer> l = new ArrayList<Integer>();
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

    @Test
    public void listGetSeveralStrings() {
        List<String> l = new ArrayList<String>();
        String[] elements = new String[] { "a", "b", "c", "d", "e", "f", "g" };
        for (int i = 0; i < elements.length; i++) {
            l.add(elements[i]);
        }
        for (int i = 0; i < elements.length; i++) {
            assertEquals(elements[i], l.get(i));
        }
    }
}
