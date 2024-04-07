package ru.latypov.my_list.my_list_array;

import java.util.Iterator;

public class SimpleArrayIterator<E> implements Iterator<E> {

    private int index = 0;
    private E[] values;

    public SimpleArrayIterator(E[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    @Override
    public E next() {
        return values[index++];
    }
}
