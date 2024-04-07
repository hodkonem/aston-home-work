package ru.latypov.my_list.my_list_array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicArrayTest {

    private DynamicArray<Integer> integerArray;
    private DynamicArray<String> stringArray;

    @BeforeEach
    void setUp() {
        integerArray = new DynamicArray<>();
        stringArray = new DynamicArray<>();
    }

    @Test
    void testAddMethodShouldIncreaseSizeByOne() {
        int initialSize = integerArray.size();
        integerArray.add(6);
        int newSize = integerArray.size();
        assertEquals(initialSize + 1, newSize);
    }

    @Test
    void testAddMethodShouldAddElementToEndOfArray() {
        integerArray.add(3);
        integerArray.add(10);
        assertEquals(Integer.valueOf(3), integerArray.get(0));
    }

    @Test
    void testAddMethodShouldNotModifyArrayIfExceptionIsThrown() {
        integerArray.add(5);
        assertEquals(1, integerArray.size());

        try {
            integerArray.add(10);
            fail("Expected ClassException to be thrown");
        } catch (ClassCastException e) {
            assertEquals(1, integerArray.size());
        }
    }

    @Test
    void testSize() {
        assertEquals(0, integerArray.size());

        integerArray.add(4);
        assertEquals(1, integerArray.size());

        integerArray.add(10);
        assertEquals(2, integerArray.size());
    }

    @Test
    void testAddAllWithValidElements() {
        ResizableList<Integer> collection = new DynamicArray<>();
        collection.add(1);
        collection.add(2);

        assertEquals(2, integerArray.size());
    }

    @Test
    void testEmpty() {
        assertTrue(integerArray.isEmpty());
    }

    @Test
    void testBubbleSort() {
        integerArray = new DynamicArray<>();
        integerArray.add(3);
        integerArray.add(2);
        integerArray.add(1);

        DynamicArrayUtils.bubbleSort(integerArray);

        assertEquals(1, integerArray.get(0));
    }

}
