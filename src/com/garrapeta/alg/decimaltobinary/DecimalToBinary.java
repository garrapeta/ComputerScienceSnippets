package com.garrapeta.alg.decimaltobinary;

public class DecimalToBinary {

    public static final int SIZE = 32;

    //
    // public static boolean[] decimalToBinary(int n) {
    // boolean[] bits = new boolean[SIZE];
    //
    // for (int i = bits.length - 1; i >= 0; i--) {
    // double pow = Math.pow(2, i);
    // if (pow <= n) {
    // n -= pow;
    // bits[i] = true;
    // }
    // }
    //
    // return bits;
    // }

    public static boolean[] decimalToBinary(int n) {
        boolean[] bits = new boolean[SIZE];
        int pos = 0;

        while (n > 0) {

            bits[pos] = (n % 2) == 1;
            n = n / 2;

            pos++;
            if (pos > SIZE) {
                throw new IllegalStateException();
            }
        }

        return bits;
    }
}
