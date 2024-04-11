package ru.latypov.my_list.my_list_array;

import org.junit.jupiter.api.Assertions;
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
    public void testAddMethodShouldDoubleCapacityWhenReached() {
        DynamicArray<String> dynamicArray = new DynamicArray<String>();
        if (dynamicArray.getCapacity() == 0) {
            dynamicArray.add("element0");
            Assertions.assertEquals(1, dynamicArray.getCapacity());
        }

        int initialCapacity = dynamicArray.getCapacity();
        for (int i = 1; i < initialCapacity; i++) {
            dynamicArray.add("element" + i);
        }
        int expectedCapacity = initialCapacity * 2;

        dynamicArray.add("newElement");
        Assertions.assertEquals(expectedCapacity, dynamicArray.getCapacity());
    }

    @Test
    void testRemoveValidIndex() {
        integerArray.add(6);
        integerArray.add(8);
        integerArray.add(10);
        assertEquals(Integer.valueOf(8), integerArray.get(1));

        assertTrue(integerArray.remove(1));
        assertEquals(Integer.valueOf(10), integerArray.get(1));
    }

    @Test
    void testRemoveInvalidIndex() {
        assertFalse(integerArray.remove(2));
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

        integerArray.add(5);
        integerArray.add(7);

        assertTrue(integerArray.addAll(collection));

        assertEquals(Integer.valueOf(5), integerArray.get(0));
        assertEquals(Integer.valueOf(1), integerArray.get(2));
        assertEquals(Integer.valueOf(2), integerArray.get(3));
    }

    @Test
    void testIsEmpty() {
        assertTrue(integerArray.isEmpty());
        integerArray.add(5);
        assertFalse(integerArray.isEmpty());
    }

    @Test
    void testSetValidIndex() {
        integerArray.add(3);
        integerArray.add(6);
        assertEquals(Integer.valueOf(6), integerArray.get(1));

        integerArray.set(1, 8);
        assertEquals(Integer.valueOf(8), integerArray.get(1));
    }

    @Test
    void testSetInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            integerArray.set(2, 8);
        });
    }

    @Test
    void testAddAllWithEmptyCollection() {
        ResizableList<Integer> emptyCollection = new DynamicArray<>();
        assertFalse(integerArray.addAll(emptyCollection));
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
