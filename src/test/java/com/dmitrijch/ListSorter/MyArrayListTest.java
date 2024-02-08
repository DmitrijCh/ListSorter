package com.dmitrijch.ListSorter;

import com.dmitrijch.ListSorter.collections.MyArrayList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayListTest {
    private MyArrayList<Integer> myArrayList;

    @Before
    public void setUp() {
        myArrayList = new MyArrayList<>();
    }

    @Test
    public void testAddAndGet() {
        myArrayList.add(5);
        myArrayList.add(3);
        assertEquals(Integer.valueOf(5), myArrayList.get(0));
        assertEquals(Integer.valueOf(3), myArrayList.get(1));
    }

    @Test
    public void testAddAtIndex() {
        myArrayList.add(5);
        myArrayList.add(3);
        myArrayList.add(1, 10);
        assertEquals(Integer.valueOf(5), myArrayList.get(0));
        assertEquals(Integer.valueOf(10), myArrayList.get(1));
        assertEquals(Integer.valueOf(3), myArrayList.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAtInvalidIndex() {
        myArrayList.add(5);
        myArrayList.add(3);
        myArrayList.add(3, 10); // Should throw IndexOutOfBoundsException
    }

    @Test
    public void testRemove() {
        myArrayList.add(5);
        myArrayList.add(3);
        myArrayList.remove(0);
        assertEquals(1, myArrayList.size());
        assertEquals(Integer.valueOf(3), myArrayList.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveAtInvalidIndex() {
        myArrayList.add(5);
        myArrayList.remove(1); // Should throw IndexOutOfBoundsException
    }

    @Test
    public void testClear() {
        myArrayList.add(5);
        myArrayList.add(3);

        try {
            myArrayList.clear();
            assertEquals(0, myArrayList.size());
            assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.get(0));
            assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.get(1));
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }


    @Test
    public void testQuickSort() {
        myArrayList.add(5);
        myArrayList.add(3);
        myArrayList.add(8);
        myArrayList.add(2);
        myArrayList.add(1);
        myArrayList.quickSort();
        assertEquals(Integer.valueOf(1), myArrayList.get(0));
        assertEquals(Integer.valueOf(2), myArrayList.get(1));
        assertEquals(Integer.valueOf(3), myArrayList.get(2));
        assertEquals(Integer.valueOf(5), myArrayList.get(3));
        assertEquals(Integer.valueOf(8), myArrayList.get(4));
    }
}
