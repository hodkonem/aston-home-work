package ru.latypov.my_list.my_list_array;

public class DynamicArrayUtils {

    public static <T extends Comparable<? super T>> void bubbleSort(DynamicArray<T> list) {
        boolean sorted;
        for (int i = 0; i < list.size() - 1; i++) {
            sorted = true;
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.values[j].compareTo(list.values[j + 1]) > 0) {
                    T temp = list.values[j];
                    list.values[j] = list.values[j + 1];
                    list.values[j + 1] = temp;
                    sorted = false;
                }
            }
            if (sorted) break;
        }
    }
}
