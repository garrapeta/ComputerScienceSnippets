package com.garrapeta.alg.tsp;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Travelling salesman problem with branch and bound
 * 
 * @author garrapeta
 *
 */
public class TSVBB {

    /**
     * @param matrix
     *            adjacency matrix
     * @return sequence of cities visited
     */
    public int[] solve(int[][] matrix) {
        final PriorityQueue<Node> queue = new PriorityQueue<Node>();
        Node best = new Node(null, -1, Integer.MAX_VALUE);

        queue.add(new Node(null, 0, 0));

        while (!queue.isEmpty()) {
            final Node expanding = queue.remove();
            for (int i = 0; i < matrix.length; i++) {
                if (i == expanding.city) {
                    continue;
                }
                final Node child = new Node(expanding, i, matrix[expanding.city][i]);
                if (!isPartialSolution(child)) {
                    continue;
                }
                if (child.cost >= best.cost) {
                    continue;
                }
                if (isSolution(child, matrix.length)) {
                    best = child;
                } else {
                    queue.add(child);
                }
            }
        }

        return createPath(best, matrix.length);
    }

    private boolean isPartialSolution(Node node) {
        Set<Integer> visitted = new HashSet<Integer>();
        while (node != null) {
            final int currentCity = node.city;
            if (visitted.contains(currentCity)) {
                return false;
            }
            visitted.add(currentCity);
            node = node.prev;
        }
        return true;
    }

    private boolean isSolution(Node node, int totalCities) {
        int visittedCount = 0;
        while (node != null) {
            node = node.prev;
            visittedCount++;
        }
        return visittedCount == totalCities;
    }

    private int[] createPath(Node node, int size) {
        final int[] path = new int[size];
        for (int i = 0; i < size && node != null; i++) {
            path[i] = node.city;
            node = node.prev;
        }
        return path;
    }

    private class Node implements Comparable<Node> {
        private final Node prev;
        private final int city;
        private final int cost;

        public Node(Node prev, int currentCity, int cost) {
            super();
            this.prev = prev;
            this.city = currentCity;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

}
