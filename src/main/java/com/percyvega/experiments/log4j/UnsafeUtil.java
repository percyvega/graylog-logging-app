package com.percyvega.experiments.log4j;

public abstract class UnsafeUtil {

    public static int retrieveElement(int i) {
        int[] array = new int[0];
        return array[i];
    }

    public static int obtainLength(String s) {
        return s.length();
    }

    public static int calculateQuotient(int dividend, int divisor) {
        return dividend / divisor;
    }

    public static void throwCustomException(String s) {
        throw new CustomException(s);
    }

}