package com.sigmaukraine.aklymenko.bench.collections.tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Andriy Klymenko
 */
public class GenericKeyTreeTest {

    private GenericKeyTree<String, Integer> theTree;

    @Before
    public void init() {
        theTree = new GenericKeyTree<>();
        fill();
    }

    @Test
    public void should_fill_tree() {
        assertEquals("g", theTree.getRoot().getKey());
        assertEquals("b", theTree.getRoot().getLeft().getKey());
        assertEquals("h", theTree.getRoot().getRight().getKey());
        assertEquals("a", theTree.getRoot().getLeft().getLeft().getKey());
        assertEquals("e", theTree.getRoot().getLeft().getRight().getKey());
        assertEquals("f", theTree.getRoot().getLeft().getRight().getRight().getKey());
        assertEquals("c", theTree.getRoot().getLeft().getRight().getLeft().getKey());
        assertEquals("d", theTree.getRoot().getLeft().getRight().getLeft().getRight().getKey());
    }

    @Test
    public void should_find() {
        assertEquals(50, theTree.find("g").intValue());
        assertEquals(25, theTree.find("b").intValue());
        assertEquals(75, theTree.find("h").intValue());
        assertEquals(12, theTree.find("a").intValue());
        assertEquals(37, theTree.find("e").intValue());
        assertEquals(43, theTree.find("f").intValue());
        assertEquals(30, theTree.find("c").intValue());
        assertEquals(33, theTree.find("d").intValue());
    }

    @Test
    public void should_delete_if_two_children() {
        theTree.delete("b");
        assertEquals(50, theTree.getRoot().getValue().intValue());
        assertEquals(30, theTree.getRoot().getLeft().getValue().intValue());
        assertEquals(75, theTree.getRoot().getRight().getValue().intValue());
        assertEquals(12, theTree.getRoot().getLeft().getLeft().getValue().intValue());
        assertEquals(37, theTree.getRoot().getLeft().getRight().getValue().intValue());
        assertEquals(43, theTree.getRoot().getLeft().getRight().getRight().getValue().intValue());
        assertEquals(33, theTree.getRoot().getLeft().getRight().getLeft().getValue().intValue());
    }

    @Test
    public void should_delete_if_no_children() {
        theTree.delete("h");
        assertEquals(50, theTree.getRoot().getValue().intValue());
        assertEquals(25, theTree.getRoot().getLeft().getValue().intValue());
        assertEquals(null, theTree.getRoot().getRight());
        assertEquals(12, theTree.getRoot().getLeft().getLeft().getValue().intValue());
        assertEquals(37, theTree.getRoot().getLeft().getRight().getValue().intValue());
        assertEquals(43, theTree.getRoot().getLeft().getRight().getRight().getValue().intValue());
        assertEquals(30, theTree.getRoot().getLeft().getRight().getLeft().getValue().intValue());
        assertEquals(33, theTree.getRoot().getLeft().getRight().getLeft().getRight().getValue().intValue());
    }

    @Test
    public void should_delete_if_one_children() {
        theTree.delete("c");
        assertEquals(50, theTree.getRoot().getValue().intValue());
        assertEquals(25, theTree.getRoot().getLeft().getValue().intValue());
        assertEquals(75, theTree.getRoot().getRight().getValue().intValue());
        assertEquals(12, theTree.getRoot().getLeft().getLeft().getValue().intValue());
        assertEquals(37, theTree.getRoot().getLeft().getRight().getValue().intValue());
        assertEquals(43, theTree.getRoot().getLeft().getRight().getRight().getValue().intValue());
        assertEquals(33, theTree.getRoot().getLeft().getRight().getLeft().getValue().intValue());
    }

    private void fill() {
        theTree.insert("g", 50);
        theTree.insert("b", 25);
        theTree.insert("h", 75);
        theTree.insert("a", 12);
        theTree.insert("e", 37);
        theTree.insert("f", 43);
        theTree.insert("c", 30);
        theTree.insert("d", 33);
    }
}
