package com.garrapeta.cs.sort;

import com.garrapeta.ds.Heap.HeapArrayHelper;

public class HeapSort implements SortAlgorithm {

    @Override
    public void sort(int[] a) {
        HeapArrayHelper.toHeap(a);

        int size = a.length;
        for (int i = 0; i < a.length; i++) {
            int next = HeapArrayHelper.delete(a, 0);
            size--;
            a[size] = next;
        }
    }
}
