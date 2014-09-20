package com.garrapeta.cs.sort;

import java.util.Stack;

/**
 * Not a real, academic sort algorithm, Actually an exercise from
 * "Cracking the code interview 4th edition", page 52
 *
 */
public class StackSort implements SortAlgorithm {

    @Override
    public void sort(int[] a) {
        // initialization

        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        for (int i = 0; i < a.length; i++) {
            s1.push(a[i]);
        }

        // algorithm
        while (!s1.isEmpty()) {
            int n1 = s1.pop();

            while (!s2.isEmpty() && n1 > s2.peek()) {
                s1.push(s2.pop());
            }
            s2.push(n1);
        }

        // copy back to array
        for (int i = 0; i < a.length; i++) {
            a[i] = s2.pop();
        }

    }

}
