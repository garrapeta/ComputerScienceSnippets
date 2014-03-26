package com.garrapeta.ds;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

import com.garrapeta.ds.Heap.HeapArrayHelper;

public class HeapTest {

    private Random r = new Random();

    @Test
    public void insert_works() {
        Heap h = new Heap(3);

        h.insert(1);
        h.insert(0);
        h.insert(2);

        assertTrue(isValid(h));
    }

    @Test
    public void insert_works2() {

        int size = 100;
        Heap h = new Heap(size);

        for (int i = 0; i < size; i++) {
            h.insert(r.nextInt());
        }

        assertTrue(isValid(h));
    }

    @Test
    public void constructorUsingArray_works() {
        int size = 100;
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = r.nextInt();
        }
        Heap h = new Heap(a);
        assertTrue(isValid(h));
    }

    @Test
    public void delete_works() {
        int size = 100;
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = r.nextInt();
        }

        Heap h = new Heap(a);
        while (h.size > 0) {
            h.delete();
            assertTrue(isValid(h));
        }
    }

    private boolean isValid(Heap h) {
        return HeapArrayHelper.isValid(h.a, h.size);
    }
}
