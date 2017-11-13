package com.agrawal93.search;

import java.util.List;

/**
 *
 * @author Hardik Agrawal [ hardik93@ymail.com ]
 */
public class BinarySearch {

    public static enum BinarySearchMethod {
        RECURSIVE,
        ITERATIVE
    }

    public static <T extends Comparable> T search(T[] array, T value, BinarySearchMethod method) {
        switch (method) {
            case RECURSIVE:
                return search_Recursive(array, 0, array.length - 1, value);
            case ITERATIVE:
                return search_Iterative(array, value);
            default:
                throw new IllegalArgumentException("Invalid Search Method specified.");
        }
    }

    public static <T extends Comparable> T search(List<T> list, T value, BinarySearchMethod method) {
        switch (method) {
            case RECURSIVE:
                return search_Recursive(list, 0, list.size() - 1, value);
            case ITERATIVE:
                return search_Iterative(list, value);
            default:
                throw new IllegalArgumentException("Invalid Search Method specified.");
        }
    }

    public static <T extends Comparable> T search_Recursive(T[] array, int low, int high, T value) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            int compareValue = value.compareTo(array[mid]);
            if (compareValue == 0) return array[mid];
            if (compareValue < 0) return search_Recursive(array, low, mid - 1, value);
            return search_Recursive(array, mid + 1, high, value);
        }

        return null;
    }

    public static <T extends Comparable> T search_Recursive(List<T> list, int low, int high, T value) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            T currentValue = list.get(mid);
            int compareValue = value.compareTo(currentValue);
            if (compareValue == 0) return currentValue;
            if (compareValue < 0) return search_Recursive(list, low, mid - 1, value);
            return search_Recursive(list, mid + 1, high, value);
        }

        return null;
    }

    private static <T extends Comparable> T search_Iterative(T[] array, T value) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int compareValue = value.compareTo(array[mid]);
            if(compareValue == 0) return array[mid];
            else if(compareValue < 0) high = mid - 1;
            else low = mid + 1;
        }
        return null;
    }

    private static <T extends Comparable> T search_Iterative(List<T> list, T value) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            T currentValue = list.get(mid);
            int compareValue = value.compareTo(currentValue);
            if(compareValue == 0) return currentValue;
            else if(compareValue < 0) high = mid - 1;
            else low = mid + 1;
        }
        return null;
    }

}
