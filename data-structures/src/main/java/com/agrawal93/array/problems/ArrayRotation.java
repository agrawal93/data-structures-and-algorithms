package com.agrawal93.array.problems;

import com.agrawal93.array.utils.ArrayUtils;
import com.agrawal93.math.GCD;

/**
 *
 * Array Rotation utility that rotates the array
 *
 * @author Hardik Agrawal [ hardik93@ymail.com ]
 */
public class ArrayRotation {

    public static enum RotationMethod {
        TEMP_ARRAY,
        ONE_BY_ONE,
        JUGGLING_ALGORITHM,
        REVERSAL_ALGORITHM,
        BLOCK_SWAP_ALGORITHM
    }

    /**
     *
     * @param array Array to be rotated
     * @param rotateBy Count of elements to be rotated
     * @param method Method of rotation to be applied
     */
    public static <T> void rotate(T array[], int rotateBy, RotationMethod method) {
        if (rotateBy >= array.length) {
            rotateBy %= array.length;
        }

        switch (method) {
            case TEMP_ARRAY:
                rotateArray_TempArray(array, rotateBy);
                return;
            case ONE_BY_ONE:
                rotateArray_OneByOne(array, rotateBy);
                return;
            case JUGGLING_ALGORITHM:
                rotateArray_JugglingAlgorithm(array, rotateBy);
                return;
            case REVERSAL_ALGORITHM:
                rotateArray_ReversalAlgorithm(array, rotateBy);
                return;
            case BLOCK_SWAP_ALGORITHM:
                rotateArray_BlockSwapAlgorithm(array, rotateBy);
                return;
            default:
                throw new IllegalArgumentException("Invalid Rotation Method specified.");
        }
    }

    /**
     *
     * Rotates the array using a temporary array GeeksForGeeks link:
     * http://www.geeksforgeeks.org/array-rotation/
     *
     * Time Complexity : O(array.length) Space Complexity : O(rotateBy)
     *
     * @param array Array to be rotated
     * @param rotateBy Count of elements to be rotated
     */
    private static <T> void rotateArray_TempArray(T array[], int rotateBy) {
        Object temp[] = new Object[rotateBy];
        for (int i = 0, k = 0; i < array.length; i++) {
            if (i < rotateBy) {
                temp[i] = array[i];
            }

            array[i] = (T)((i < array.length - rotateBy) ? array[rotateBy + i] : temp[k++]);
        }
    }

    /**
     *
     * Rotates the array elements one at a time GeeksForGeeks link:
     * http://www.geeksforgeeks.org/array-rotation/
     *
     * Time Complexity : O(array.length * rotateBy) Space Complexity : O(1)
     *
     * @param array Array to be rotated
     * @param rotateBy Count of elements to be rotated
     */
    private static <T> void rotateArray_OneByOne(T array[], int rotateBy) {
        for (int i = 0; i < rotateBy; i++) {
            T temp = array[0];
            for (int j = 0; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }
            array[array.length - 1] = temp;
        }
    }

    /**
     *
     * Rotates the array using a Juggling Algorithm GeeksForGeeks link:
     * http://www.geeksforgeeks.org/array-rotation/
     *
     * Time Complexity : O(array.length) Space Complexity : O(1)
     *
     * @param array Array to be rotated
     * @param rotateBy Count of elements to be rotated
     */
    private static <T> void rotateArray_JugglingAlgorithm(T array[], int rotateBy) {
        long gcd = GCD.gcd(rotateBy, array.length, GCD.GCDMethod.EUCLIDEAN);
        for (int i = 0; i < gcd; i++) {
            T temp = array[i];
            int j = i;
            while (true) {
                int k = j + rotateBy;
                if (k >= array.length) {
                    k -= array.length;
                }
                if (k == i) {
                    break;
                }
                array[j] = array[k];
                j = k;
            }
            array[j] = temp;
        }
    }

    /**
     *
     * Rotates the array using Reversal Algorithm GeeksForGeeks link:
     * http://www.geeksforgeeks.org/program-for-array-rotation-continued-reversal-algorithm/
     *
     * Time Complexity : O(array.length) Space Complexity : O(1)
     *
     * @param array Array to be rotated
     * @param rotateBy Count of elements to be rotated
     */
    private static <T> void rotateArray_ReversalAlgorithm(T array[], int rotateBy) {
        ArrayUtils.reverse(array, 0, rotateBy - 1);
        ArrayUtils.reverse(array, rotateBy, array.length - 1);
        ArrayUtils.reverse(array, 0, array.length - 1);
    }

    /**
     *
     * Rotates the array using Block Swap Algorithm GeeksForGeeks link:
     * http://www.geeksforgeeks.org/block-swap-algorithm-for-array-rotation/
     *
     * Time Complexity : O(array.length) Space Complexity : O(1)
     *
     * @param array Array to be rotated
     * @param rotateBy Count of elements to be rotated
     */
    private static <T> void rotateArray_BlockSwapAlgorithm(T array[], int rotateBy) {
        if (rotateBy == 0) {
            return;
        }

        int fi = rotateBy;
        int si = array.length - rotateBy;

        while (fi != si) {
            if (fi < si) {
                ArrayUtils.swap(array, rotateBy - fi, rotateBy - fi + si, fi);
                si -= fi;
            } else {
                ArrayUtils.swap(array, rotateBy - fi, rotateBy, si);
                fi -= si;
            }
        }

        ArrayUtils.swap(array, rotateBy - fi, rotateBy, fi);
    }

}
