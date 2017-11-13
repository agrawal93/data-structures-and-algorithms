package com.agrawal93.array.problems;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Hardik Agrawal [ hardik93@ymail.com ]
 */
public class ArrayRotationTest {

    private static final Integer ARRAY[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static final Integer RESULT[] = {5, 6, 7, 8, 9, 10, 1, 2, 3, 4};
    private final int ROTATE_BY = 4;

    @Test
    public void test_TempArray() {
        System.out.println("[TEST] Array Rotation using Temporary Array");
        Integer array[] = ARRAY.clone();
        ArrayRotation.rotate(array, ROTATE_BY, ArrayRotation.RotationMethod.TEMP_ARRAY);
        Assert.assertArrayEquals(array, RESULT);
    }

    @Test
    public void test_OneByOne() {
        System.out.println("[TEST] Array Rotation by rotating elements One by One");
        Integer array[] = ARRAY.clone();
        ArrayRotation.rotate(array, ROTATE_BY, ArrayRotation.RotationMethod.ONE_BY_ONE);
        Assert.assertArrayEquals(array, RESULT);
    }

    @Test
    public void test_JugglingAlgorithm() {
        System.out.println("[TEST] Array Rotation using Juggling Algorithm");
        Integer array[] = ARRAY.clone();
        ArrayRotation.rotate(array, ROTATE_BY, ArrayRotation.RotationMethod.JUGGLING_ALGORITHM);
        Assert.assertArrayEquals(array, RESULT);
    }

    @Test
    public void test_ReversalAlgorithm() {
        System.out.println("[TEST] Array Rotation using Reversal Algorithm");
        Integer array[] = ARRAY.clone();
        ArrayRotation.rotate(array, ROTATE_BY, ArrayRotation.RotationMethod.REVERSAL_ALGORITHM);
        Assert.assertArrayEquals(array, RESULT);
    }

    @Test
    public void test_BlockSwapAlgorithm() {
        System.out.println("[TEST] Array Rotation using Block Swap Algorithm");
        Integer array[] = ARRAY.clone();
        ArrayRotation.rotate(array, ROTATE_BY, ArrayRotation.RotationMethod.BLOCK_SWAP_ALGORITHM);
        Assert.assertArrayEquals(array, RESULT);
    }

}
