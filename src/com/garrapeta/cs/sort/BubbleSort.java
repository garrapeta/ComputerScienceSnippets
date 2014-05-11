package com.garrapeta.cs.sort;

public class BubbleSort implements SortAlgorithm {

    @Override
    public void sort(int[] a) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < a.length - 1; i++) {
                int j = i + 1;
                if (a[j] < a[i]) {
                    int tmp = a[j];
                    a[j] = a[i];
                    a[i] = tmp;
                    swapped = true;
                    break;
                }
            }
        } while (swapped);
    }

}
