package com.garrapeta.cs.sort;

public class InsertionSort implements SortAlgorithm {

    @Override
    public void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int item = a[i];

            int j = i;
            while (j > 0 && a[j - 1] > item) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = item;
        }

    }

}
