package com.garrapeta.edi;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.garrapeta.edi.BinarySearchTree.Node;

public class BinarySearchTreeTest {

    @Test
    public void add_addsRoot_ifEmpty() {
        BinarySearchTree bst = new BinarySearchTree();
        int key = 3;
        Object value = new Object();

        bst.put(key, value);

        assertEquals(key, bst.root.key);
        assertEquals(value, bst.root.value);
    }

    @Test
    public void add_addsToLeft_ifSmaller() {
        BinarySearchTree bst = new BinarySearchTree();
        int key1 = 3;
        Object value1 = new Object();

        int key2 = 2;
        Object value2 = new Object();

        bst.put(key1, value1);
        bst.put(key2, value2);

        assertEquals(key2, bst.root.left.key);
        assertEquals(value2, bst.root.left.value);
    }

    @Test
    public void add_addsToRight_ifBigger() {
        BinarySearchTree bst = new BinarySearchTree();
        int key1 = 3;
        Object value1 = new Object();

        int key2 = 4;
        Object value2 = new Object();

        bst.put(key1, value1);
        bst.put(key2, value2);

        assertEquals(key2, bst.root.right.key);
        assertEquals(value2, bst.root.right.value);
    }

    @Test
    public void get_returnsTheCorrectValue() {
        BinarySearchTree bst = create();

        assertEquals((String) bst.get(8), "eight");
        assertEquals((String) bst.get(5), "five");
        assertEquals((String) bst.get(4), "four");
        assertEquals((String) bst.get(9), "nine");
        assertEquals((String) bst.get(7), "seven");
        assertEquals((String) bst.get(11), "eleven");
        assertEquals((String) bst.get(1), "one");
        assertEquals((String) bst.get(3), "three");
        assertEquals((String) bst.get(2), "two");
    }

    @Test
    public void preOrder_traversesTreeCorrectly() {
        BinarySearchTree bst = create();
        List<Node> l = bst.preOrder();

        assertEquals(l.get(0).key, 8);
        assertEquals(l.get(1).key, 5);
        assertEquals(l.get(2).key, 4);
        assertEquals(l.get(3).key, 1);
        assertEquals(l.get(4).key, 3);
        assertEquals(l.get(5).key, 2);
        assertEquals(l.get(6).key, 7);
        assertEquals(l.get(7).key, 9);
        assertEquals(l.get(8).key, 11);

    }

    @Test
    public void inOrder_traversesTreeCorrectly() {
        BinarySearchTree bst = create();
        List<Node> l = bst.inOrder();

        assertEquals(l.get(0).key, 1);
        assertEquals(l.get(1).key, 2);
        assertEquals(l.get(2).key, 3);
        assertEquals(l.get(3).key, 4);
        assertEquals(l.get(4).key, 5);
        assertEquals(l.get(5).key, 7);
        assertEquals(l.get(6).key, 8);
        assertEquals(l.get(7).key, 9);
        assertEquals(l.get(8).key, 11);
    }

    @Test
    public void postOrder_traversesTreeCorrectly() {
        BinarySearchTree bst = create();
        List<Node> l = bst.postOrder();

        assertEquals(l.get(0).key, 2);
        assertEquals(l.get(1).key, 3);
        assertEquals(l.get(2).key, 1);
        assertEquals(l.get(3).key, 4);
        assertEquals(l.get(4).key, 7);
        assertEquals(l.get(5).key, 5);
        assertEquals(l.get(6).key, 11);
        assertEquals(l.get(7).key, 9);
        assertEquals(l.get(8).key, 8);
    }

    @Test
    public void levelOrder_traversesTreeCorrectly() {
        BinarySearchTree bst = create();
        List<Node> l = bst.levelOrder();

        assertEquals(l.get(0).key, 8);
        assertEquals(l.get(1).key, 5);
        assertEquals(l.get(2).key, 9);
        assertEquals(l.get(3).key, 4);
        assertEquals(l.get(4).key, 7);
        assertEquals(l.get(5).key, 11);
        assertEquals(l.get(6).key, 1);
        assertEquals(l.get(7).key, 3);
        assertEquals(l.get(8).key, 2);
    }

    private BinarySearchTree create() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.put(8, "eight");
        bst.put(5, "five");
        bst.put(4, "four");
        bst.put(9, "nine");
        bst.put(7, "seven");
        bst.put(11, "eleven");
        bst.put(1, "one");
        bst.put(3, "three");
        bst.put(2, "two");

        return bst;
    }
}
