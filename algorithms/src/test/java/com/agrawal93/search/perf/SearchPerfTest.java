package com.agrawal93.search.perf;

import com.agrawal93.search.BinarySearch;
import com.agrawal93.search.ExponentialSearch;
import com.agrawal93.search.InterpolationSearch;
import com.agrawal93.search.JumpSearch;
import com.agrawal93.search.LinearSearch;
import com.google.common.base.Stopwatch;
import java.util.ArrayList;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Hardik Agrawal [ hardik93@ymail.com ]
 */
public class SearchPerfTest {
    
    private static final int MAX_SIZE = 1000001;
    private static final List<Integer> LIST = new ArrayList<>();
    private static final Integer ARRAY[] = new Integer[MAX_SIZE];
    
    @BeforeClass
    public static void init() {
        for(Integer i=0; i<MAX_SIZE; i++) {
            ARRAY[i] = i;
            LIST.add(i);
        }
    }
    
//    @Test
//    public void linearSearch_Array() {
//        Stopwatch timer = Stopwatch.createStarted();
//        for(int i=0; i<MAX_SIZE; i++) {
//            LinearSearch.search(ARRAY, i);
//        }
//        System.out.println("[PERF] Linear Search from Array: " + timer.stop());
//    }
//    
//    @Test
//    public void linearSearch_List() {
//        Stopwatch timer = Stopwatch.createStarted();
//        for(int i=0; i<MAX_SIZE; i++) {
//            LinearSearch.search(LIST, i);
//        }
//        System.out.println("[PERF] Linear Search from List: " + timer.stop());
//    }
    
    @Test
    public void jumpSearch_Array() {
        Stopwatch timer = Stopwatch.createStarted();
        for(int i=0; i<MAX_SIZE; i++) {
            JumpSearch.search(ARRAY, i);
        }
        System.out.println("[PERF] Jump Search from Array: " + timer.stop());
    }
    
    @Test
    public void jumpSearch_List() {
        Stopwatch timer = Stopwatch.createStarted();
        for(int i=0; i<MAX_SIZE; i++) {
            JumpSearch.search(LIST, i);
        }
        System.out.println("[PERF] Jump Search from List: " + timer.stop());
    }
    
    @Test
    public void exponentialSearch_Array() {
        Stopwatch timer = Stopwatch.createStarted();
        for(int i=0; i<MAX_SIZE; i++) {
            ExponentialSearch.search(ARRAY, i);
        }
        System.out.println("[PERF] Exponential Search from Array: " + timer.stop());
    }
    
    @Test
    public void exponentialSearch_List() {
        Stopwatch timer = Stopwatch.createStarted();
        for(int i=0; i<MAX_SIZE; i++) {
            ExponentialSearch.search(LIST, i);
        }
        System.out.println("[PERF] Exponential Search from List: " + timer.stop());
    }
    
    @Test
    public void interpolationSearch_Array() {
        Stopwatch timer = Stopwatch.createStarted();
        for(int i=0; i<MAX_SIZE; i++) {
            InterpolationSearch.search(ARRAY, i);
        }
        System.out.println("[PERF] Interpolation Search from Array: " + timer.stop());
    }
    
    @Test
    public void interpolationSearch_List() {
        Stopwatch timer = Stopwatch.createStarted();
        for(int i=0; i<MAX_SIZE; i++) {
            InterpolationSearch.search(LIST, i);
        }
        System.out.println("[PERF] Interpolation Search from List: " + timer.stop());
    }
    
    @Test
    public void binarySearch_Array_Iterative() {
        Stopwatch timer = Stopwatch.createStarted();
        for(int i=0; i<MAX_SIZE; i++) {
            BinarySearch.search(ARRAY, i, BinarySearch.BinarySearchMethod.ITERATIVE);
        }
        System.out.println("[PERF] Binary Search (Iterative) from Array: " + timer.stop());
    }
    
    @Test
    public void binarySearch_List_Iterative() {
        Stopwatch timer = Stopwatch.createStarted();
        for(int i=0; i<MAX_SIZE; i++) {
            BinarySearch.search(LIST, i, BinarySearch.BinarySearchMethod.ITERATIVE);
        }
        System.out.println("[PERF] Binary Search (Iterative) from List: " + timer.stop());
    }
    
    @Test
    public void binarySearch_Array_Recursive() {
        Stopwatch timer = Stopwatch.createStarted();
        for(int i=0; i<MAX_SIZE; i++) {
            BinarySearch.search(ARRAY, i, BinarySearch.BinarySearchMethod.RECURSIVE);
        }
        System.out.println("[PERF] Binary Search (Recursive) from Array: " + timer.stop());
    }
    
    @Test
    public void binarySearch_List_Recursive() {
        Stopwatch timer = Stopwatch.createStarted();
        for(int i=0; i<MAX_SIZE; i++) {
            BinarySearch.search(LIST, i, BinarySearch.BinarySearchMethod.RECURSIVE);
        }
        System.out.println("[PERF] Binary Search (Recursive) from List: " + timer.stop());
    }
    
}
