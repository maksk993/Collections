package com.maksk993.Collections.MyCollections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMain {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= 10; i++){
            list.add(i);
        }

        MyList<Integer> mylist = new MyArrayList<>(list);
        MyList<Integer> mylist2 = new MyArrayList<>();

        System.out.println("Java array list: " + list);
        System.out.println("My array list: " + mylist);
        System.out.println("My array list 2: " + mylist2);
        System.out.println("mylist.equals(mylist2): " + mylist.equals(mylist2));

        mylist.remove(5);
        mylist.removeFirst();
        mylist.removeLast();

        System.out.println("My array list after all removes: " + mylist);

        mylist.add(4, 555);
        mylist.addFirst(100);
        mylist.addLast(1000);

        System.out.println("My array list after all adds: " + mylist);
        System.out.println("Size: " + mylist.size() + "; isEmpty: " + mylist.isEmpty());
        System.out.println("Contains 555: " + mylist.contains(555) + "; Contains 200: " + mylist.contains(200));
        System.out.println("Index of 555: " + mylist.indexOf(555) + "; Index of 200: " + mylist.indexOf(200));

        mylist.clear();
        System.out.println("My list after clear() " + mylist + "; Size: " + mylist.size());
    }
}
