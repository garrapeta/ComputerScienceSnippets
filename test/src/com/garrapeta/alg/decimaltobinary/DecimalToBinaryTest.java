package com.garrapeta.alg.decimaltobinary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class DecimalToBinaryTest {

    @Test
    public void binaryToDecimal_of53_returnsCorrectValue() {
        boolean[] bits = getBinaryFor53();
        int value = binaryToDecimal(bits);

        assertEquals(53, value);
    }

    @Test
    public void decimalToBinary_of53_returnsCorrectValue() {
        boolean[] expected = getBinaryFor53();

        boolean[] actual = DecimalToBinary.decimalToBinary(53);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    private int binaryToDecimal(boolean[] bits) {
        int val = 0;

        for (int i = 0; i < bits.length; i++) {
            boolean bit = bits[i];
            if (bit) {
                double pow = Math.pow(2, i);
                val += pow;
            }
        }

        return val;
    }

    private boolean[] getBinaryFor53() {
        boolean[] bits = new boolean[32];
        bits[0] = true;
        bits[1] = false;
        bits[2] = true;
        bits[3] = false;
        bits[4] = true;
        bits[5] = true;

        return bits;
    }
}
