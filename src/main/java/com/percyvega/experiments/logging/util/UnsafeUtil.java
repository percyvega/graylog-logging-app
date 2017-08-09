package com.percyvega.experiments.logging.util;

import com.percyvega.experiments.logging.exception.CustomException;

public abstract class UnsafeUtil {

    public static void performAnUnsafeOperation(long timeToSleep) {
        int modulus = (int) (timeToSleep % 13);

        switch (modulus) {
            case 0:
            case 1:
            case 2:
                obtainLength(null);
                break;
            case 3:
            case 4:
            case 5:
                calculateQuotient(modulus, 0);
                break;
            case 6:
            case 7:
            case 8:
                retrieveElement(modulus);
                break;
            case 9:
            case 10:
            case 11:
                throw new CustomException("timeToSleep is " + timeToSleep);
            default:
                break;
        }
    }

    private static int retrieveElement(int i) {
        int[] array = new int[0];
        return array[i];
    }

    private static int obtainLength(String s) {
        return s.length();
    }

    private static int calculateQuotient(int dividend, int divisor) {
        return dividend / divisor;
    }

}