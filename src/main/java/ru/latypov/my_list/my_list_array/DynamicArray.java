package ru.latypov.my_list.my_list_array;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

class DynamicArray<E> implements ResizableList<E> {

    protected E[] values;
    private int elementCount = 0;

    public DynamicArray() {
        values = (E[]) new Object[0];
    }

    public DynamicArray(ResizableList<E> collection) {
        addAll(collection);
    }

    public DynamicArray(Collection<E> otherCollection) {
        this.values = (E[]) new Object[otherCollection.size()];
        int index = 0;
        for (E element : otherCollection) {
            this.values[index++] = element;
        }
    }

    private void checkValuesLength() {
        if (elementCount == values.length) {
            int newCapacity = values.length * 3 / 2 + 1;  // Стандартное увеличение размера в коллекциях Java.
            E[] newArray = (E[]) new Object[newCapacity];
            System.arraycopy(values, 0, newArray, 0, values.length);
            values = newArray;
        }
    }

    @Override
    public boolean add(E e) {
        checkValuesLength();
        if (elementCount == values.length) {
            int newCapacity = Math.max(values.length * 2, elementCount + 1);
            E[] newArray = Arrays.copyOf(values, newCapacity);
            values = newArray;
        }
        values[elementCount++] = e;
        return true;
    }

    @Override
    public int size() {
        return elementCount;
    }

    @Override
    public void update(int index, E e) {
        values[index] = e;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= elementCount) {
            return false;
        }
        int moveCount = elementCount - index - 1;
        if (moveCount > 0) {
            System.arraycopy(values, index + 1, values, index, moveCount);
        }
        values[--elementCount] = null;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return elementCount == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new SimpleArrayIterator<>(values);
    }

    public E get(int index) {
        return values[index];
    }

    public int getCapacity() {
        return values.length;
    }

    public boolean addAll(ResizableList<E> collection) {
        if (collection == null || collection.isEmpty()) {
            return false;
        }
        int newSize = this.size() + collection.size();
        if (newSize > values.length) {
            int newCapacity = Math.max(values.length * 2, newSize); // Выбираем большую из двух величин
            E[] newArray = (E[]) new Object[newCapacity];
            System.arraycopy(values, 0, newArray, 0, elementCount);
            values = newArray;
        }

        for (E element : collection) {
            this.add(element);
        }
        return true;
    }

    public void set(int index, E element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        values[index] = element;
    }

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