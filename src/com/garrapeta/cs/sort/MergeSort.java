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

    private static int[] merge(int[] a, int[] left, int[] right) {
        int i1 = 0;   // index into left array
        int i2 = 0;   // index into right array
        
        for (int i = 0; i < a.length; i++) {
            if (i2 >= right.length || (i1 < left.length && 
                    left[i1] <= right[i2])) {
                a[i] = left[i1];    // take from left
                i1++;
            } else {
                a[i] = right[i2];   // take from right
                i2++;
            }
        }
        return a;
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
