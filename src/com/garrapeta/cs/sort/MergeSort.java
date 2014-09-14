package com.garrapeta.cs.sort;

public class MergeSort implements SortAlgorithm {

    @Override
    public void sort(int[] a) {
        if (a.length <= 1) {
            return;
        }
        int[] left = leftHalf(a);
        int[] right = rightHalf(a);
        sort(left);
        sort(right);
        merge(a, left, right);
    }

    private void merge(int[] a, int[] left, int[] right) {
        int lidx = 0;
        int ridx = 0;

        for (int i = 0; i < a.length; i++) {
            int smaller;

            if (lidx == left.length) {
                smaller = right[ridx];
                ridx++;
            } else if (ridx == right.length) {
                smaller = left[lidx];
                lidx++;
            } else if (left[lidx] < right[ridx]) {
                smaller = left[lidx];
                lidx++;
            } else {
                smaller = right[ridx];
                ridx++;
            }

            a[i] = smaller;
        }

    }

    private int[] leftHalf(int[] a) {
        int middle = a.length / 2;
        int[] half = new int[middle];
        System.arraycopy(a, 0, half, 0, half.length);
        return half;
    }

    private int[] rightHalf(int[] a) {
        int middle = a.length / 2;
        int[] half = new int[a.length - middle];
        System.arraycopy(a, middle, half, 0, half.length);
        return half;
    }

}
