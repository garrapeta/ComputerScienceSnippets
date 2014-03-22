package com.garrapeta.cs.sort;

public class SelectionSort implements SortAlgorithm {

    @Override
    public void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int minIdx = i;

            int j;
            for (j = i; j < a.length; j++) {
                if (a[j] < a[minIdx]) {
                    minIdx = j;
                }
            }

            int tmp = a[i];
            a[i] = a[minIdx];
            a[minIdx] = tmp;
        }

    }

}
