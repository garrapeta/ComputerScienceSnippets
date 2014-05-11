package com.garrapeta.alg.fibonacci;

import com.garrapeta.alg.fibonacci.Fibonacci.FibonacciRecursive;

public class FibonacciRecursiveTest extends FibonacciTest {

    @Override
    protected Fibonacci getFibonacci() {
        return new FibonacciRecursive();
    }

}
