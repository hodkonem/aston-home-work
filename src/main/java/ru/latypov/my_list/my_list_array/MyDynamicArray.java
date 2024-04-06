package ru.latypov.my_list.my_list_array;

import java.util.Iterator;

class MyDynamicArray<E> implements ResizableList<E> {

    private E[] values;

    public MyDynamicArray() {
        values = (E[]) new Object[0];
    }

    public MyDynamicArray(ResizableList<? extends E> collection) {
        for (E element : collection) {
            add(element);
        }
    }

    @Override
    public boolean add(E e) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = e;
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public void update(int index, E e) {

    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    public E get(int index) {
        return values[index];
    }
}
