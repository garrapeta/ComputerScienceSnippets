package com.garrapeta.cs.sort;

public class QuickSort implements SortAlgorithm {

    @Override
    public void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }
    
    private void sort(int[] a, int b, int e) {
        // Get the pivot element from the middle of the list
        int pivot = a[b + (e - b) / 2];

        int i = b, j = e;

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (a[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (a[j] > pivot) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                swap(a, i, j);
                i++;
                j--;
            }
        }

        // Recursion
        if (b < j) {
            sort(a, b, j);
        }
        if (i < e) {
            sort(a, i, e);
        }

    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
