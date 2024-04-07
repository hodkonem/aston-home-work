package ru.latypov.my_list.my_list_array;

public interface ResizableList<E> extends Iterable<E> {
    boolean add(E e);

    int size();

    void update(int index, E e);

    boolean isEmpty();
}
