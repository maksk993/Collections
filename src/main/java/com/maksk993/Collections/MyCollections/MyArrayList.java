package com.maksk993.Collections.MyCollections;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyArrayList<T> implements MyList<T> {
    private int m_size = 0;
    private int m_capacity;
    private final static int DEFAULT_CAPACITY = 10;
    private T[] m_data;

    public MyArrayList(){
        clear();
    }

    public MyArrayList(int initialCapacity) throws IllegalArgumentException{
        m_capacity = initialCapacity;
        if (m_capacity < 0) throw new IllegalArgumentException(String.valueOf(initialCapacity));
        if (m_capacity == 0) m_capacity++;
        m_data = (T[]) new Object[m_capacity];
    }

    public MyArrayList(Collection<? extends T> collection){
        m_capacity = collection.size();
        if (m_capacity == 0) m_capacity++;
        m_data = (T[]) new Object[m_capacity];
        addAll(collection);
    }

    @Override
    public int size(){
        return m_size;
    }

    @Override
    public void add(T element){
        if (m_size == m_capacity) {
            m_capacity <<= 1;
            T[] new_data = (T[]) new Object[m_capacity];
            for (int i = 0; i < m_size; i++){
                new_data[i] = m_data[i];
            }
            m_data = new_data;
        }
        m_data[m_size++] = element;
    }

    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException {
        if (index < 0 || index > m_size) throw new IndexOutOfBoundsException(String.valueOf(index));
        add(null);
        for (int i = m_size - 2; i >= index; i--){
            m_data[i + 1] = m_data[i];
        }
        m_data[index] = element;
    }

    @Override
    public void addFirst(T element) {
        add(0, element);
    }

    @Override
    public void addLast(T element) {
        add(m_size, element);
    }

    @Override
    public void addAll(Collection<? extends T> collection){
        for (T element : collection){
            add(element);
        }
    }

    @Override
    public void addAll(int index, Collection<? extends T> collection) {
        for (T element : collection){
            add(index++, element);
        }
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= m_size) throw new IndexOutOfBoundsException(String.valueOf(index));
        return m_data[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < m_size; i++){
            if (m_data[i].equals((T) o)) return i;
        }
        return -1;
    }

    @Override
    public void set(int index, T element) throws IndexOutOfBoundsException {
        if (index < 0 || index >= m_size) throw new IndexOutOfBoundsException(String.valueOf(index));
        m_data[index] = element;
    }

    @Override
    public void remove(int index) throws NoSuchElementException {
        if (index < 0 || index >= m_size) throw new NoSuchElementException();
        for (int i = index; i < m_size - 1; i++) {
            m_data[i] = m_data[i + 1];
        }
        m_size--;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(m_size - 1);
    }

    @Override
    public boolean isEmpty() {
        return m_size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public void clear() {
        m_size = 0;
        m_capacity = DEFAULT_CAPACITY;
        m_data = (T[]) new Object[m_capacity];
    }

    @Override
    public String toString() {
        T[] str_data = (T[]) new Object[m_size];
        for (int i = 0; i < m_size; i++){
            str_data[i] = m_data[i];
        }
        return Arrays.toString(str_data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyArrayList<?> that = (MyArrayList<?>) o;
        return m_size == that.m_size && Objects.deepEquals(m_data, that.m_data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(m_size, Arrays.hashCode(m_data));
    }
}
