package com.agrawal93.search;

import java.util.List;

/**
 *
 * @author Hardik Agrawal [ hardik93@ymail.com ]
 */
public class ExponentialSearch {
    
    public static <T extends Comparable> T search(T[] array, T value) {
        if(array[0].compareTo(value) == 0) return array[0];
        
        int index = 1;
        while(index < array.length && array[index].compareTo(value) <= 0) {
            index *= 2;
        }
        
        return BinarySearch.search_Recursive(array, index/2, Math.min(index, array.length-1), value);
    }

    public static <T extends Comparable> T search(List<T> list, T value) {
        T currentValue = list.get(0);
        if(currentValue.compareTo(value) == 0) return currentValue;
        
        int index = 1;
        while(index < list.size() && list.get(index).compareTo(value) <= 0) {
            index *= 2;
        }
        
        return BinarySearch.search_Recursive(list, index/2, Math.min(index, list.size()-1), value);
    }
    
}
