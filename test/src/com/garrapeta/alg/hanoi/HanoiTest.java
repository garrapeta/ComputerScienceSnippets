package com.garrapeta.alg.hanoi;

import java.util.Stack;

import org.junit.Test;

public class HanoiTest {

    @Test
    public void hanoiTest1() {
        hanoiTest(1);
    }

    @Test
    public void hanoiTest3() {
        hanoiTest(3);
    }

    @Test
    public void hanoiTest15() {
        hanoiTest(15);
    }

    private void hanoiTest(int n) {
        Hanoi h = new Hanoi(n);
        assertValidTower(h.getSourceStack(), n);
        h.solve();
        assertValidTower(h.getTargetStack(), n);
    }

    private void assertValidTower(Stack<Integer> stack, int n) {
        int prev = Integer.MAX_VALUE;
        org.junit.Assert.assertEquals(stack.size(), n);
        for (int i = 0; i < n; i++) {
            int val = stack.elementAt(i);
            org.junit.Assert.assertTrue(val < prev);
            prev = val;
        }

    }
}
