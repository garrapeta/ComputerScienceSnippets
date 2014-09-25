package com.garrapeta.cs.sort;

public class QuickSort2 implements SortAlgorithm {

    @Override
    public void sort(int[] a) {
        quicksort(a, 0, a.length - 1);
    }

    private void quicksort(int[] a, int b, int e) {
        int idx = partition(a, b, e);
        if (b < idx - 1) {
            quicksort(a, b, idx - 1);
        }
        if (idx < e) {
            quicksort(a, idx, e);
        }

    }

    private int partition(int[] a, int b, int e) {
        int m = b + (e - b) / 2;
        int pivot = a[m];

        while (b <= e) {
            while (a[b] < pivot) {
                b++;
            }
            while (a[e] > pivot) {
                e--;
            }

            if (b <= e) {
                int aux = a[b];
                a[b] = a[e];
                a[e] = aux;

                b++;
                e--;
            }
        }

        return b;
    }

}
