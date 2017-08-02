package com.percyvega.experiments.log4j;

public class UnsafeUtil {

    public static int getElement(int i) {
        int[] array = new int[0];
        return array[i];
    }

    public static int getLength(String s) {
        return s.length();
    }

    public static int getQuotient(int dividend, int divisor) {
        return dividend / divisor;
    }

    public static void throwCustomException(String s) {
        throw new CustomException(s);
    }

}