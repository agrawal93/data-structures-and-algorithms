package com.agrawal93.search;

import java.util.List;

/**
 *
 * @author Hardik Agrawal [ hardik93@ymail.com ]
 */
public class LinearSearch {

    public static <T extends Comparable> T search(T[] array, T value) {
        for (T element : array) {
            if (element != null && element.compareTo(value) == 0) return element;
        }
        return null;
    }

    public static <T extends Comparable> T search(List<T> list, T value) {
        for (T element : list) {
            if (element != null && element.compareTo(value) == 0) return element;
        }
        return null;
    }

}
