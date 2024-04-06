package com.maksk993.Collections.MyCollections;

import java.util.LinkedList;
import java.util.List;

public class LinkedListMain {
    public static void main(String[] args){
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i <= 10; i++){
            list.add(i);
        }

        MyList<Integer> mylist = new MyLinkedList<>(list);
        MyList<Integer> mylist2 = new MyLinkedList<>();

        System.out.println("Java linked list: " + list);
        System.out.println("My linked list: " + mylist);
        System.out.println("My linked list 2: " + mylist2);
        System.out.println("mylist.equals(mylist2): " + mylist.equals(mylist2));

        mylist.remove(5);
        mylist.removeFirst();
        mylist.removeLast();

        System.out.println("My linked list after all removes: " + mylist);

        mylist.add(4, 555);
        mylist.addFirst(100);
        mylist.addLast(1000);

        System.out.println("My linked list after all adds: " + mylist);
        System.out.println("Size: " + mylist.size() + "; isEmpty: " + mylist.isEmpty());
        System.out.println("Contains 555: " + mylist.contains(555) + "; Contains 200: " + mylist.contains(200));
        System.out.println("Index of 555: " + mylist.indexOf(555) + "; Index of 200: " + mylist.indexOf(200));

        mylist.clear();
        System.out.println("My list after clear() " + mylist + "; Size: " + mylist.size());
    }
}
