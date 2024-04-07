package ru.latypov.my_list.my_list_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyDynamicArrayTest {

    @Test
    void testAddMethodShouldIncreaseSizeByOne() {
        MyDynamicArray<Integer> myDynamicArray = new MyDynamicArray<>();
        int initialSize = myDynamicArray.size();
        myDynamicArray.add(6);
        int newSize = myDynamicArray.size();
        assertEquals(initialSize + 1, newSize);
    }

    @Test
    void testAddMethodShouldAddElementToEndOfArray() {
        MyDynamicArray<Integer> myDynamicArray = new MyDynamicArray<>();
        myDynamicArray.add(3);
        myDynamicArray.add(10);
        assertEquals(Integer.valueOf(3), myDynamicArray.get(0));
    }

    @Test
    void testAddMethodShouldNotModifyArrayIfExceptionIsThrown() {
        MyDynamicArray<Integer> myDynamicArray = new MyDynamicArray<>();
        myDynamicArray.add(5);
        assertEquals(1, myDynamicArray.size());

        try {
            myDynamicArray.add(10);
            fail("Expected ClassException to be thrown");
        } catch (ClassCastException e) {
            assertEquals(1, myDynamicArray.size());
        }
    }

    @Test
    void testSize() {
        MyDynamicArray<Integer> myDynamicArray = new MyDynamicArray<>();
        assertEquals(0, myDynamicArray.size());

        myDynamicArray.add(4);
        assertEquals(1, myDynamicArray.size());

        myDynamicArray.add(10);
        assertEquals(2, myDynamicArray.size());
    }

    @Test
    void testAddAll() {
        MyDynamicArray<Integer> array = new MyDynamicArray<>();
        MyDynamicArray<Integer> collection = new MyDynamicArray<>();
        collection.add(1);
        collection.add(2);

        assertTrue(array.addAll(collection));
        assertEquals(2, array.size());

        // Тест на случай, если происходит ClassCastException
        MyDynamicArray<Integer> intCollection = new MyDynamicArray<>();
        intCollection.add(3);
        intCollection.add(4);

    }

    @Test
    void testEmpty(){
       MyDynamicArray<Integer> myDynamicArray = new MyDynamicArray<>();
       assertTrue(myDynamicArray.isEmpty());
    }


}
