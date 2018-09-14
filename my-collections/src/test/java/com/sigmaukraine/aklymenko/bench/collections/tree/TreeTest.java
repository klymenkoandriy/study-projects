package com.sigmaukraine.aklymenko.bench.collections.tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Andriy Klymenko
 */
public class TreeTest {

    private Tree<Integer> theTree;

    @Before
    public void init() {
        theTree = new Tree<>();
        fill();
    }

    @Test
    public void should_fill_tree() {
        assertEquals(50, theTree.getRoot().getKey());
        assertEquals(25, theTree.getRoot().getLeft().getKey());
        assertEquals(75, theTree.getRoot().getRight().getKey());
        assertEquals(12, theTree.getRoot().getLeft().getLeft().getKey());
        assertEquals(37, theTree.getRoot().getLeft().getRight().getKey());
        assertEquals(43, theTree.getRoot().getLeft().getRight().getRight().getKey());
        assertEquals(30, theTree.getRoot().getLeft().getRight().getLeft().getKey());
        assertEquals(33, theTree.getRoot().getLeft().getRight().getLeft().getRight().getKey());
    }

    @Test
    public void should_find() {
        assertEquals(50, theTree.find(50).getKey());
        assertEquals(25, theTree.find(25).getKey());
        assertEquals(75, theTree.find(75).getKey());
        assertEquals(12, theTree.find(12).getKey());
        assertEquals(37, theTree.find(37).getKey());
        assertEquals(43, theTree.find(43).getKey());
        assertEquals(30, theTree.find(30).getKey());
        assertEquals(33, theTree.find(33).getKey());
    }

    @Test
    public void should_delete_if_two_choldren() {
        theTree.delete(25);
        assertEquals(50, theTree.getRoot().getKey());
        assertEquals(30, theTree.getRoot().getLeft().getKey());
        assertEquals(75, theTree.getRoot().getRight().getKey());
        assertEquals(12, theTree.getRoot().getLeft().getLeft().getKey());
        assertEquals(37, theTree.getRoot().getLeft().getRight().getKey());
        assertEquals(43, theTree.getRoot().getLeft().getRight().getRight().getKey());
        assertEquals(33, theTree.getRoot().getLeft().getRight().getLeft().getKey());
    }

    @Test
    public void should_delete_if_no_children() {
        theTree.delete(75);
        assertEquals(50, theTree.getRoot().getKey());
        assertEquals(25, theTree.getRoot().getLeft().getKey());
        assertEquals(null, theTree.getRoot().getRight());
        assertEquals(12, theTree.getRoot().getLeft().getLeft().getKey());
        assertEquals(37, theTree.getRoot().getLeft().getRight().getKey());
        assertEquals(43, theTree.getRoot().getLeft().getRight().getRight().getKey());
        assertEquals(30, theTree.getRoot().getLeft().getRight().getLeft().getKey());
        assertEquals(33, theTree.getRoot().getLeft().getRight().getLeft().getRight().getKey());
    }

    @Test
    public void should_delete_if_one_children() {
        theTree.delete(30);
        assertEquals(50, theTree.getRoot().getKey());
        assertEquals(25, theTree.getRoot().getLeft().getKey());
        assertEquals(75, theTree.getRoot().getRight().getKey());
        assertEquals(12, theTree.getRoot().getLeft().getLeft().getKey());
        assertEquals(37, theTree.getRoot().getLeft().getRight().getKey());
        assertEquals(43, theTree.getRoot().getLeft().getRight().getRight().getKey());
        assertEquals(33, theTree.getRoot().getLeft().getRight().getLeft().getKey());
    }

    private void fill() {
        theTree.insert(50, 50);
        theTree.insert(25, 25);
        theTree.insert(75, 75);
        theTree.insert(12, 12);
        theTree.insert(37, 37);
        theTree.insert(43, 43);
        theTree.insert(30, 30);
        theTree.insert(33, 33);
    }

}
