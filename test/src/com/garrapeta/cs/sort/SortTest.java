package com.garrapeta.cs.sort;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public abstract class SortTest {

    private final SortAlgorithm sorter;
    private Random r;

    public SortTest(SortAlgorithm sorter) {
        super();
        this.sorter = sorter;
    }

    @Before
    public void setUp() throws Exception {
        r = new Random();
    }

    @Test
    public void sort_sorts_twoNumbers() {
        int[] a = new int[] { 4, 3 };
        sorter.sort(a);
        assert (isSorted(a));
    }

    @Test
    public void sort_sorts_inASimpleCase() {
        int[] a = new int[] { 4, 3, 2, 1 };
        sorter.sort(a);
        assert (isSorted(a));
    }

    @Test
    public void sort_sorts_averageCase() {
        int[] a = new int[100];

        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt();
        }

        sorter.sort(a);
        assert (isSorted(a));
    }

    private boolean isSorted(int[] a) {
        int prev = Integer.MIN_VALUE;
        for (int current : a) {
            if (current > prev) {
                return false;
            }
            prev = current;
        }
        return true;
    }
}
