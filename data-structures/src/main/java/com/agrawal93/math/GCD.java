package com.agrawal93.math;

/**
 *
 * Utility to calculate GCD
 *
 * @author Hardik Agrawal [ hardik93@ymail.com ]
 */
public class GCD {

    public static enum GCDMethod {
        EUCLIDEAN
    }

    /**
     * 
     * Calculate GCD for two numbers
     * 
     * @param a First Number
     * @param b Second Number
     * @param method GCD Calculation Method
     * @return GCD of a and b
     */
    public static long gcd(long a, long b, GCDMethod method) {
        switch(method) {
            case EUCLIDEAN:
                return gcd_Euclidean(a, b);
            default:
                throw new IllegalArgumentException("Invalid GCD Method");
        }
    }
    
    /**
     * 
     * GCD of two numbers using Euclidean Formula
     * 
     * @param a First Number
     * @param b Second Number
     * @return GCD of a and b calculated using Euclidean Formula
     */
    private static long gcd_Euclidean(long a, long b) {
        return (a == 0) ? b : gcd_Euclidean(b % a, a);
    }

}
