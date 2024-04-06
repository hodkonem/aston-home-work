package ru.latypov.my_list.my_list_array;

import java.util.Iterator;

class MyDynamicArray<E> implements ResizableList<E> {

    private E[] values;

    public MyDynamicArray(E[] values) {
        values = (E[]) new Object();
    }

    public MyDynamicArray(ResizableList<? extends E> collection)

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void update(int index, E e) {

    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
