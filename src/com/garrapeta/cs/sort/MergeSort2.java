package com.garrapeta.cs.sort;

public class MergeSort2 implements SortAlgorithm {

    @Override
    public void sort(int[] a) {
        mergesort(a, new int[a.length], 0, a.length);
    }

    private void mergesort(int[] a, int aux[], int b, int e) {
        if (b + 1 >= e) {
            return;
        }

        int m = b + ((e - b) / 2);
        mergesort(a, aux, b, m);
        mergesort(a, aux, m, e);

        merge(a, aux, b, m, e);
    }

    private void merge(int[] a, int[] aux, int b, int m, int e) {
        int h0idx = b;
        int h1idx = m;

        for (int i = b; i < e; i++) {

            if (h0idx < m) {
                if (h1idx < e) {
                    // in the middle of both
                    if (a[h0idx] < a[h1idx]) {
                        aux[i] = a[h0idx];
                        h0idx++;
                    } else {
                        aux[i] = a[h1idx];
                        h1idx++;
                    }
                } else {
                    // second half consumed
                    aux[i] = a[h0idx];
                    h0idx++;
                }
            } else {
                // first half consumed
                aux[i] = a[h1idx];
                h1idx++;
            }

        }

        System.arraycopy(aux, b, a, b, (e - b));
    }

}
