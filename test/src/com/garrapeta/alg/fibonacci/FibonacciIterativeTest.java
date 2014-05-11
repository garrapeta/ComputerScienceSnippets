package com.garrapeta.alg.fibonacci;

import com.garrapeta.alg.fibonacci.Fibonacci.FibonacciIterative;

public class FibonacciIterativeTest extends FibonacciTest {

    @Override
    protected Fibonacci getFibonacci() {
        return new FibonacciIterative();
    }

}
