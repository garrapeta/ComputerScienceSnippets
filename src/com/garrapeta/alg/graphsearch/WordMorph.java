package com.garrapeta.alg.graphsearch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * http://en.wikipedia.org/wiki/A*_search_algorithm
 * 
 */
public class WordMorph {

    public Node morph(String start, String end) {
        PriorityList candidates = new PriorityList();
        List<Node> visitted = new ArrayList<Node>();
        candidates.add(new Node(start, null, 0));

        while (!candidates.isEmpty()) {
            if (candidates.isEmpty()) {
                return null;
            }
            final Node current = candidates.get(0);
            candidates.remove(current);

            visitted.add(current);
            if (current.word.equals(end)) {
                return current;
            }

            List<String> variations = createVariations(current.word);
            for (String variation : variations) {
                if (contains(visitted, variation)) {
                    continue;
                }
                if (!isValid(variation)) {
                    continue;
                }
                int cost = current.cost + getDistance(variation, end);
                Node candidate = new Node(variation, current, cost);
                candidates.add(candidate);
            }
        }

        return null;

    }

    private List<String> createVariations(String word) {
        List<String> list = new ArrayList<String>();
        return list;
    }

    private boolean isValid(String variation) {
        // TODO Auto-generated method stub
        return false;
    }

    private boolean contains(List<Node> visitted, String child) {
        // TODO Auto-generated method stub
        return false;
    }

    private int getDistance(String child, String end) {
        // TODO Auto-generated method stub
        return 0;
    }

    private class Node {
        private String word;
        private int cost;
        private Node prev;

        public Node(String word, Node prev, int cost) {
            this.cost = cost;
            this.prev = prev;
        }

    }

    private class PriorityList implements List<Node> {

        @Override
        public int size() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public boolean isEmpty() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean contains(Object o) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public Iterator<Node> iterator() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Object[] toArray() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public <T> T[] toArray(T[] a) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public boolean add(Node e) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean remove(Object o) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Node> c) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Node> c) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public void clear() {
            // TODO Auto-generated method stub

        }

        @Override
        public Node get(int index) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Node set(int index, Node element) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public void add(int index, Node element) {
            // TODO Auto-generated method stub

        }

        @Override
        public Node remove(int index) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public int indexOf(Object o) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public ListIterator<Node> listIterator() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public ListIterator<Node> listIterator(int index) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public List<Node> subList(int fromIndex, int toIndex) {
            // TODO Auto-generated method stub
            return null;
        }

    }
}
