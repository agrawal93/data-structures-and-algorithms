package com.agrawal93.array.problems.perf;

import com.agrawal93.array.problems.*;
import com.google.common.base.Stopwatch;
import java.util.Random;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Hardik Agrawal [ hardik93@ymail.com ]
 */
public class ArrayRotationPerfTest {

    private static final int MAX_SIZE = 1000001;
    private static final int ROTATE_BY = (int) Math.floor(Math.random() * MAX_SIZE);

    private static final Integer ARRAY[] = new Integer[MAX_SIZE];

    @BeforeClass
    public static void init() {
        Random random = new Random();
        for (int i = 0; i < MAX_SIZE; i++) {
            ARRAY[i] = random.nextInt();
        }
    }

    @Test
    public void test_TempArray() {
        Stopwatch timer = Stopwatch.createStarted();
        ArrayRotation.rotate(ARRAY.clone(), ROTATE_BY, ArrayRotation.RotationMethod.TEMP_ARRAY);
        System.out.println("[PERF] Array Rotation using Temporary Array: " + timer.stop());
    }

//    @Test
    public void test_OneByOne() {
        Stopwatch timer = Stopwatch.createStarted();
        ArrayRotation.rotate(ARRAY.clone(), ROTATE_BY, ArrayRotation.RotationMethod.ONE_BY_ONE);
        System.out.println("[PERF] Array Rotation by rotating elements One by One: " + timer.stop());
    }

    @Test
    public void test_JugglingAlgorithm() {
        Stopwatch timer = Stopwatch.createStarted();
        ArrayRotation.rotate(ARRAY.clone(), ROTATE_BY, ArrayRotation.RotationMethod.JUGGLING_ALGORITHM);
        System.out.println("[PERF] Array Rotation using Juggling Algorithm: " + timer.stop());
    }

    @Test
    public void test_ReversalAlgorithm() {
        Stopwatch timer = Stopwatch.createStarted();
        ArrayRotation.rotate(ARRAY.clone(), ROTATE_BY, ArrayRotation.RotationMethod.REVERSAL_ALGORITHM);
        System.out.println("[PERF] Array Rotation using Reversal Algorithm: " + timer.stop());
    }

    @Test
    public void test_BlockSwapAlgorithm() {
        Stopwatch timer = Stopwatch.createStarted();
        ArrayRotation.rotate(ARRAY.clone(), ROTATE_BY, ArrayRotation.RotationMethod.TEMP_ARRAY);
        System.out.println("[PERF] Array Rotation using Block Swap Algorithm: " + timer.stop());
    }

}
