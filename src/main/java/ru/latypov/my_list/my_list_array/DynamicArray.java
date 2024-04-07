package ru.latypov.my_list.my_list_array;

import java.util.Iterator;

class DynamicArray<E> implements ResizableList<E> {

    protected E[] values;

    public DynamicArray() {
        values = (E[]) new Object[0];
    }

    public DynamicArray(ResizableList<? extends E> collection) {
        for (E element : collection) {
            add(element);
        }
    }

    @Override
    public boolean add(E e) {
        try {
            if (values.length == values.length) {
                E[] temp = values;
                values = (E[]) new Object[temp.length + 1];
                System.arraycopy(temp, 0, values, 0, temp.length);
            }
            values[values.length - 1] = e;
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public void update(int index, E e) {
        values[index] = e;
    }

    @Override
    public boolean isEmpty() {
        return values.length == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new SimpleArrayIterator<>(values);
    }

    public E get(int index) {
        return values[index];
    }

    public ResizableList<E> addAll(ResizableList<E> collection) {
        if (collection == null || collection.isEmpty()) {
            return this;
        }
        try {
            for (E element : collection) {
                add(element);
            }
            return this;
        } catch (ClassCastException ex) {
            ex.printStackTrace();

        }
        return this;
    }
}
