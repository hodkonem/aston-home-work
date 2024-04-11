package ru.latypov.my_list.my_list_array;

public class DynamicArrayUtils {
    public static <T extends Comparable<? super T>> void bubbleSort(DynamicArray<T> list) {
        boolean swapped;
        boolean sorted = false;
        do {
            swapped = false;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i - 1).compareTo(list.get(i)) > 0) {
                    T temp = list.get(i - 1);
                    list.set(i - 1, list.get(i));
                    list.set(i, temp);
                    swapped = true;
                }
            }
            sorted = !swapped;
        } while (!sorted);
    }
}
