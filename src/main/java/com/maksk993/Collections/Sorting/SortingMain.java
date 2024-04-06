package com.maksk993.Collections.Sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingMain {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 10; i >= 0; i--){
            list.add((int)(Math.random() * 10));
        }
        System.out.println("Initial list: " + list);

        MySort.sort(list);
        System.out.println("After sorting: " + list);

        MySort.sort(list, Comparator.reverseOrder());
        System.out.println("After sorting in descending order: " + list);
    }
}
