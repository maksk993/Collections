package com.maksk993.Collections.MyCollections;

import java.util.Collection;

public interface MyList<T> {
    int size();

    void add(T element);
    void add(int index, T element);
    void addFirst(T element);
    void addLast(T element);
    void addAll(Collection<? extends T> collection);

    T get(int index);

    void remove(int index);
    void removeFirst();
    void removeLast();

    boolean isEmpty();
    boolean contains(Object o);

    void clear();
}
