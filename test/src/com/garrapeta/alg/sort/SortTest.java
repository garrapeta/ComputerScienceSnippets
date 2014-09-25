package com.garrapeta.alg.sort;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.garrapeta.cs.sort.SortAlgorithm;

public abstract class SortTest {

    private final SortAlgorithm sorter;
    private Random r;

    public SortTest(SortAlgorithm sorter) {
        super();
        this.sorter = sorter;
    }

    @Before
    public void setUp()
            throws Exception {
        r = new Random();
    }

    @Test
    public void sort_sorts_twoNumbers() {
        int[] a = new int[] {
                4,
                3 };
        sorter.sort(a);
        assertTrue(isSorted(a));
    }

    @Test
    public void sort_sorts_threeNumbers() {
        int[] a = new int[] {
                4,
                2,
                3 };
        sorter.sort(a);
        assertTrue(isSorted(a));
    }

    @Test
    public void sort_sorts_fourNumbers() {
        int[] a = new int[] {
                4,
                2,
                3,
                0 };
        sorter.sort(a);
        assertTrue(isSorted(a));
    }

    @Test
    public void sort_sorts_fourNumbers2() {
        int[] a = new int[] {
                2,
                3,
                -1,
                1 };
        sorter.sort(a);
        assertTrue(isSorted(a));
    }

    @Test
    public void sort_sorts_inASimpleCase() {
        int[] a = new int[] {
                4,
                3,
                2,
                1 };
        sorter.sort(a);
        assertTrue(isSorted(a));
    }

    @Test
    public void sort_sorts_averageCase() {
        int[] a = new int[100];

        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt();
        }

        sorter.sort(a);
        assertTrue(isSorted(a));
    }

    private boolean isSorted(int[] a) {
        int prev = Integer.MIN_VALUE;
        for (int current : a) {
            if (current < prev) {
                return false;
            }
            prev = current;
        }
        return true;
    }
}
