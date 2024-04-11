package ru.latypov.my_list.my_list_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicArrayUtilsTest {

    private DynamicArray<Integer> integerArray;

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