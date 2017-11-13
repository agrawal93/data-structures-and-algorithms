package com.agrawal93.search;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Hardik Agrawal [ hardik93@ymail.com ]
 */
public class BinarySearchTest {

    private static final List<Integer> LIST = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
    private static final Integer ARRAY[] = LIST.toArray(new Integer[LIST.size()]);
    
    @Test
    public void binarySearch_Iterative() {
        for(Integer i=0; i<30; i++) {
            Integer searchResultArray = BinarySearch.search(ARRAY, i, BinarySearch.BinarySearchMethod.ITERATIVE);
            Integer searchResultList = BinarySearch.search(LIST, i, BinarySearch.BinarySearchMethod.ITERATIVE);
            if(LIST.contains(i)) {
                Assert.assertEquals(i, searchResultArray);
                Assert.assertEquals(i, searchResultList);
            } else {
                Assert.assertEquals(null, searchResultArray);
                Assert.assertEquals(null, searchResultList);
            }
        }
    }

    @Test
    public void binarySearch_Recursive() {
        for(Integer i=0; i<30; i++) {
            Integer searchResultArray = BinarySearch.search(ARRAY, i, BinarySearch.BinarySearchMethod.RECURSIVE);
            Integer searchResultList = BinarySearch.search(LIST, i, BinarySearch.BinarySearchMethod.RECURSIVE);
            if(LIST.contains(i)) {
                Assert.assertEquals(i, searchResultArray);
                Assert.assertEquals(i, searchResultList);
            } else {
                Assert.assertEquals(null, searchResultArray);
                Assert.assertEquals(null, searchResultList);
            }
        }
    }
    
}
