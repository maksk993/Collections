package com.maksk993.Collections.MyCollections;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyLinkedList<T> implements MyList<T> {
    private class Node {
        T element;
        Node prev;
        Node next;

        Node(){}

        Node(Node prev){
            this.prev = prev;
        }
    }

    private int m_size = 0;
    private Node head = null;
    private Node tail = null;

    public MyLinkedList(){

    }

    public MyLinkedList(Collection<? extends T> collection){
        addAll(collection);
    }

    @Override
    public int size() {
        return m_size;
    }

    @Override
    public void add(T element) {
        addLast(element);
    }

    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException  {
        if (index < 0 || index > m_size) throw new IndexOutOfBoundsException(String.valueOf(index));
        if (index == 0){
            addFirst(element);
        }
        else if (index == m_size) {
            addLast(element);
        }
        else {
            Node current = head;
            int startIndex = 0;
            while (startIndex != index){
                startIndex++;
                current = current.next;
            }

            Node new_element = new Node(current.prev);
            current.prev.next = new_element;
            current.prev = new_element;
            new_element.element = element;
            new_element.next = current;
            m_size++;
        }
    }

    @Override
    public void addFirst(T element) {
        if (m_size == 0) {
            addLast(element);
        }
        else {
            head.prev = new Node();
            head.prev.next = head;
            head = head.prev;
            head.element = element;
            m_size++;
        }
    }

    @Override
    public void addLast(T element) {
        if (m_size == 0) {
            head = tail = new Node();
            head.element = element;
        }
        else {
            tail.next = new Node(tail);
            tail = tail.next;
            tail.element = element;
        }
        m_size++;
    }

    @Override
    public void addAll(Collection<? extends T> collection) {
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
        Node current = head;
        int startIndex = 0;
        while (startIndex != index){
            startIndex++;
            current = current.next;
        }
        return current.element;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        for (Node current = head; current != null; current = current.next, index++){
            if (current.element.equals((T) o)) return index;
        }
        return -1;
    }

    @Override
    public void set(int index, T element) throws IndexOutOfBoundsException {
        if (index < 0 || index >= m_size) throw new IndexOutOfBoundsException(String.valueOf(index));
        Node current = head;
        int startIndex = 0;
        while (startIndex != index){
            startIndex++;
            current = current.next;
        }
        current.element = element;
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= m_size) throw new IndexOutOfBoundsException(String.valueOf(index));
        if (index == 0){
            removeFirst();
        }
        else if (index == m_size - 1){
            removeLast();
        }
        else {
            Node current = head;
            int startIndex = 0;
            while (startIndex != index){
                startIndex++;
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            m_size--;
        }
    }

    @Override
    public void removeFirst() throws NoSuchElementException {
        if (m_size < 1) throw new NoSuchElementException();
        if (m_size == 1){
            head = tail = null;
        }
        else {
            head.next.prev = null;
            head = head.next;
        }
        m_size--;
    }

    @Override
    public void removeLast() throws NoSuchElementException {
        if (m_size < 1) throw new NoSuchElementException();
        if (m_size == 1){
            head = tail = null;
        }
        else {
            tail.prev.next = null;
            tail = tail.prev;
        }
        m_size--;
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
        head = tail = null;
        m_size = 0;
    }

    @Override
    public String toString() {
        T[] str_data = (T[]) new Object[m_size];
        Node current = head;
        int index = 0;
        while (current != null && index < m_size){
            str_data[index++] = current.element;
            current = current.next;
        }
        return Arrays.toString(str_data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyLinkedList<?> that = (MyLinkedList<?>) o;
        return m_size == that.m_size;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(m_size);
    }
}
