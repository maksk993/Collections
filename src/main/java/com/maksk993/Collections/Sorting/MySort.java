package com.maksk993.Collections.Sorting;

import java.util.Comparator;
import java.util.List;

public class MySort {
    public static <T extends Comparable<T>> void sort(List<T> list){
        for (int i = 0; i < list.size() - 1; i++){
            boolean sorted = true;
            for (int j = 0; j < list.size() - 1 - i; j++){
                if (list.get(j).compareTo(list.get(j + 1)) > 0){
                    T tmp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tmp);
                    sorted = false;
                }
            }
            if (sorted) break;
        }
    }

    public static <T extends Comparable<T>> void sort(List<T> list, Comparator<T> comp){
        for (int i = 0; i < list.size() - 1; i++){
            boolean sorted = true;
            for (int j = 0; j < list.size() - 1 - i; j++){
                if (comp.compare(list.get(j), list.get(j + 1)) > 0){
                    T tmp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tmp);
                    sorted = false;
                }
            }
            if (sorted) break;
        }
    }
}
