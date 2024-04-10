package ru.latypov.my_list.my_list_array;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

class DynamicArray<E> implements ResizableList<E> {

    protected E[] values;
    private int elementCount = 0;

    public DynamicArray() {
        values = (E[]) new Object[10];
    }

    public DynamicArray(ResizableList<E> collection) {
        addAll(collection);
    }

    public DynamicArray(Collection<E> otherCollection) {
        this.values = (E[]) new Object[otherCollection.size()];
        int index = 0;
        for (E element : otherCollection) {
            this.values[index++] = element;
            checkValuesLength();
        }
    }

    @Override
    public boolean add(E e) {
        try {
            checkValuesLength();
            elementCount++;
            values[values.length - 1] = e;
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private void checkValuesLength() {
        if (values.length == elementCount) {
            E[] temp = values;
            values = (E[]) new Object[temp.length + temp.length / 2];
            System.arraycopy(temp, 0, values, 0, temp.length);
        }
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
        return false;
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

    public boolean addAll(ResizableList<E> collection) {
        if (collection == null || collection.isEmpty()) {
            return false;
        }
        try {
            for (E element : collection) {
                add(element);
            }
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
            return false;
        }


    }

    public <T extends Comparable<? super T>> void bubbleSort(Comparator<? super E> c) {
        boolean sorted;
        for (int i = 0; i < size() - 1; i++) {
            sorted = true;
            for (int j = 0; j < size() - i - 1; j++) {
                if (c.compare(values[j], values[j + 1]) > 0) {
                    E temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                    sorted = false;
                }
            }
            if (sorted) break;
        }
    }
}