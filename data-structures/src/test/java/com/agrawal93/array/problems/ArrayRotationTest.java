package com.agrawal93.array.problems;

import com.google.common.base.Stopwatch;
import java.util.Random;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Hardik Agrawal [ hardik93@ymail.com ]
 */
public class ArrayRotationTest {

    private final int MAX_SIZE = 1000001;
    private final Object array[] = new Object[MAX_SIZE];
    private final Object result[];

    private final int ROTATE_BY = (int) Math.floor(Math.random() * MAX_SIZE);

    public ArrayRotationTest() {
        Random random = new Random();
        for (int i = 0; i < MAX_SIZE; i++) {
            array[i] = random.nextInt();
        }
        result = array.clone();
        ArrayRotation.rotate(result, ROTATE_BY, ArrayRotation.RotationMethod.JUGGLING_ALGORITHM);
    }

    @Test
    public void test_TempArray() {
        Object array[] = this.array.clone();
        Stopwatch timer = Stopwatch.createStarted();
        ArrayRotation.rotate(array, ROTATE_BY, ArrayRotation.RotationMethod.TEMP_ARRAY);
        System.out.println("[PERF] Array Rotation using Temporary Array: " + timer.stop());
        Assert.assertArrayEquals(result, array);
    }

    //@Test
    public void test_OneByOne() {
        Object array[] = this.array.clone();
        Stopwatch timer = Stopwatch.createStarted();
        ArrayRotation.rotate(array, ROTATE_BY, ArrayRotation.RotationMethod.ONE_BY_ONE);
        System.out.println("[PERF] Array Rotation by rotating elements One by One: " + timer.stop());
        Assert.assertArrayEquals(result, array);
    }

    @Test
    public void test_JugglingAlgorithm() {
        Object array[] = this.array.clone();
        Stopwatch timer = Stopwatch.createStarted();
        ArrayRotation.rotate(array, ROTATE_BY, ArrayRotation.RotationMethod.JUGGLING_ALGORITHM);
        System.out.println("[PERF] Array Rotation using Juggling Algorithm: " + timer.stop());
        Assert.assertArrayEquals(result, array);
    }

    @Test
    public void test_ReversalAlgorithm() {
        Object array[] = this.array.clone();
        Stopwatch timer = Stopwatch.createStarted();
        ArrayRotation.rotate(array, ROTATE_BY, ArrayRotation.RotationMethod.REVERSAL_ALGORITHM);
        System.out.println("[PERF] Array Rotation using Reversal Algorithm: " + timer.stop());
        Assert.assertArrayEquals(result, array);
    }

    @Test
    public void test_BlockSwapAlgorithm() {
        Object array[] = this.array.clone();
        Stopwatch timer = Stopwatch.createStarted();
        ArrayRotation.rotate(array, ROTATE_BY, ArrayRotation.RotationMethod.BLOCK_SWAP_ALGORITHM);
        System.out.println("[PERF] Array Rotation using Block Swap Algorithm: " + timer.stop());
        Assert.assertArrayEquals(result, array);
    }

}
