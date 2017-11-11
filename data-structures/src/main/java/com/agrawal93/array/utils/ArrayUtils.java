package com.agrawal93.array.utils;

/**
 * Utility Class for Array Manipulation
 * 
 * @author Hardik Agrawal [ hardik93@ymail.com ]
 */
public class ArrayUtils {
    
    /**
     * 
     * Reverses an Array from start index till end index (inclusive)
     * 
     * @param array Array to be reversed
     * @param start Start Index
     * @param end End Index
     */
    public static <T> void reverse(T array[], int start, int end) {
        while(start < end) {
            T temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
    
    /**
     * 
     * Swaps 'count' number of elements starting from index `fi` and `si`.
     * 
     * @param array Array in which swapping needs to take place
     * @param fi Start Index of First Block
     * @param si Start Index of Second Block
     * @param count Count of elements to be swapped
     */
    public static <T> void swap(T array[], int fi, int si, int count) {
        for(int i=0; i<count; i++) {
            T temp = array[fi + i];
            array[fi + i] = array[si + i];
            array[si + i] = temp;
        }
    }
    
}
