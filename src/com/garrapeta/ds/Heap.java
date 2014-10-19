package com.garrapeta.ds;

public class Heap {

    int[] a;
    int size;

    public Heap(int capacity) {
        a = new int[capacity];
        size = 0;
    }

    public Heap(int[] fromArray) {
        HeapArrayHelper.toHeap(fromArray);
        a = fromArray;
        size = a.length;
    }

    public Heap(int[] a, int size) {
        this.a = a;
        this.size = size;
    }

    public void insert(int n) {
        HeapArrayHelper.insert(a, size, n);
        size++;
    }

    public int delete() {
        int root = HeapArrayHelper.delete(a, size);
        size--;
        return root;
    }

    public static class HeapArrayHelper {
        static int parentIdx(int i) {
            return (i - 1) / 2;
        }

        static int leftChildIdx(int i) {
            return (i * 2) + 1;
        }

        static int rightChildIdx(int i) {
            return (i * 2) + 2;
        }

        public static void insert(int[] a, int size, int n) {
            int i = size;

            a[i] = n;

            while (i > 0) {
                int pi = HeapArrayHelper.parentIdx(i);
                if (a[pi] < a[i]) {
                    HeapArrayHelper.swap(a, i, pi);
                    i = pi;
                } else {
                    break;
                }

            }
        }

        public static void toHeap(int[] a) {
            for (int i = 0; i < a.length; i++) {
                insert(a, i, a[i]);
            }
        }

        public static int delete(int[] a, int size) {
            int i = 0;
            int root = a[i];
            size--;
            a[i] = a[size];

            while (i < size / 2) {
                int li = HeapArrayHelper.leftChildIdx(i);
                int ri = HeapArrayHelper.rightChildIdx(i);

                int si = i;

                if (a[li] > a[si]) {
                    si = li;
                }
                if (a[ri] > a[si]) {
                    si = ri;
                }

                if (si == i) {
                    break;
                }
                HeapArrayHelper.swap(a, si, i);
                i = si;
            }
            return root;
        }

        public static boolean isValid(int[] a, int size) {
            for (int i = 0; i < size; i++) {
                int val = a[i];

                int leftChildIdx = leftChildIdx(i);
                if (leftChildIdx < size && val < a[leftChildIdx]) {
                    return false;
                }

                int rightChildIdx = rightChildIdx(i);
                if (rightChildIdx < size && val < a[rightChildIdx]) {
                    return false;
                }
            }

            long l = (long) Math.pow(2, 3);
            l = l & 1;
            return true;
        }

        private static void swap(int[] a, int x, int y) {
            int tmp = a[x];
            a[x] = a[y];
            a[y] = tmp;
        }

        static boolean isValid(long a, int n) {
            int zeros = 0;
            int ones = 0;

            for (int i = 0; i < n; i++) {
                if ((a & 1) > 0) {
                    ones++;
                } else {
                    zeros++;
                }
                a = a >> 1;
            }

            return zeros % 5 == 0 && ones % 3 == 0;
        }

    }
}
