package com.garrapeta.alg.fibonacci;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public abstract class FibonacciTest {

    @Test
    public void fib_0_returns_0() {
        int expected = 0;

        Fibonacci fib = getFibonacci();
        int actual = fib.fib(0);

        assertEquals(actual, expected);
    }

    @Test
    public void fib_1_returns_1() {
        int expected = 1;

        Fibonacci fib = getFibonacci();
        int actual = fib.fib(1);

        assertEquals(actual, expected);
    }

    @Test
    public void fib_2_returns_1() {
        int expected = 1;

        Fibonacci fib = getFibonacci();
        int actual = fib.fib(2);

        assertEquals(actual, expected);
    }

    @Test
    public void fib_3_returns_2() {
        int expected = 2;

        Fibonacci fib = getFibonacci();
        int actual = fib.fib(3);

        assertEquals(actual, expected);
    }

    @Test
    public void fib_4_returns_3() {
        int expected = 3;

        Fibonacci fib = getFibonacci();
        int actual = fib.fib(4);

        assertEquals(actual, expected);
    }

    @Test
    public void fib_10_returns_55() {
        int expected = 55;

        Fibonacci fib = getFibonacci();
        int actual = fib.fib(10);

        assertEquals(actual, expected);
    }

    @Test
    public void fib_12_returns_144() {
        int expected = 144;

        Fibonacci fib = getFibonacci();
        int actual = fib.fib(12);

        assertEquals(actual, expected);
    }

    protected abstract Fibonacci getFibonacci();

}
