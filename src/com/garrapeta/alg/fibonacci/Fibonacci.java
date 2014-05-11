package com.garrapeta.alg.fibonacci;

public interface Fibonacci {

    public int fib(int n);

    public class FibonacciIterative implements Fibonacci {

        @Override
        public int fib(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }

            int pprev = fib(0);
            int prev = fib(1);
            for (int i = 2; i <= n; i++) {
                int aux = prev;

                prev = pprev + prev;
                pprev = aux;
            }

            return prev;

        }

    }

    public class FibonacciRecursive implements Fibonacci {

        @Override
        public int fib(int n) {
            if (n == 0) {
                return 0;
            } else if (n == 1) {
                return 1;
            } else {
                return fib(n - 1) + fib(n - 2);
            }

        }
    }

}
