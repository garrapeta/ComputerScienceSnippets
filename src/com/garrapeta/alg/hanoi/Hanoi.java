package com.garrapeta.alg.hanoi;

import java.util.Stack;

@SuppressWarnings("unchecked")
public class Hanoi {

    private Stack<Integer>[] stacks;
    private int size;

    public Hanoi(int n) {
        size = n;
        stacks = new Stack[3];
        for (int i = 0; i < 3; i++) {
            stacks[i] = new Stack<Integer>();
        }
        for (int i = 0; i < size; i++) {
            stacks[0].add(size - i - 1);
        }
    }

    public Stack<Integer> getSourceStack() {
        return stacks[0];
    }

    public Stack<Integer> getTargetStack() {
        return stacks[2];
    }

    public void solve() {
        solve(size, stacks[0], stacks[2], stacks[1]);
    }

    private void solve(int n, Stack<Integer> src, Stack<Integer> dst, Stack<Integer> aux) {
        if (n > 1) {
            solve(n - 1, src, aux, dst);
        }
        dst.push(src.pop());
        if (n > 1) {
            solve(n - 1, aux, dst, src);
        }
    }
}
