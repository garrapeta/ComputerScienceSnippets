package com.garrapeta.edi;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    Node root;

    public BinarySearchTree() {

    }

    public void put(int key, Object value) {
        Node n = new Node(key, value);

        if (root == null) {
            root = n;
        } else {
            add(n, root);
        }
    }

    private void add(Node n, Node to) {
        if (n.key < to.key) {
            if (to.left == null) {
                to.left = n;
            } else {
                add(n, to.left);
            }
        } else if (n.key > to.key) {
            if (to.right == null) {
                to.right = n;
            } else {
                add(n, to.right);
            }
        }
    }

    public Object get(int key) {
        if (root == null) {
            return null;
        }
        return get(key, root);
    }

    private Object get(int key, Node n) {
        if (key == n.key) {
            return n.value;
        } else if (key < n.key) {
            return get(key, n.left);
        } else {
            return get(key, n.right);
        }
    }

    List<Node> preOrder() {
        List<Node> list = new ArrayList<Node>();
        if (root != null) {
            preOrder(root, list);
        }
        return list;
    }

    private void preOrder(Node n, List<Node> list) {
        list.add(n);
        if (n.left != null) {
            preOrder(n.left, list);
        }
        if (n.right != null) {
            preOrder(n.right, list);
        }
    }

    List<Node> inOrder() {
        List<Node> list = new ArrayList<Node>();
        if (root != null) {
            inOrder(root, list);
        }
        return list;
    }

    private void inOrder(Node n, List<Node> list) {
        if (n.left != null) {
            inOrder(n.left, list);
        }
        list.add(n);
        if (n.right != null) {
            inOrder(n.right, list);
        }
    }

    List<Node> postOrder() {
        List<Node> list = new ArrayList<Node>();
        if (root != null) {
            postOrder(root, list);
        }
        return list;
    }

    private void postOrder(Node n, List<Node> list) {
        if (n.left != null) {
            postOrder(n.left, list);
        }
        if (n.right != null) {
            postOrder(n.right, list);
        }
        list.add(n);
    }

    class Node {
        final int key;
        final Object value;
        Node left;
        Node right;

        private Node(int key, Object value) {
            super();
            this.key = key;
            this.value = value;
        }
    }
}
