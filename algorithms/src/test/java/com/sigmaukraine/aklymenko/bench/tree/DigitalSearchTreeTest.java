package com.sigmaukraine.aklymenko.bench.tree;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class DigitalSearchTreeTest {
    
    private DigitalSearchTree tree;

    @Before
    public void init() {
        tree = new DigitalSearchTree();
        fill();
    }

    @Test
    public void should_fill_tree() {
        assertEquals(5, tree.getRoot().getKey());
        assertEquals(6, tree.getRoot().getZeroNode().getKey());
        assertEquals(7, tree.getRoot().getOneNode().getKey());
        assertEquals(18, tree.getRoot().getZeroNode().getOneNode().getKey());
        assertEquals(13, tree.getRoot().getOneNode().getZeroNode().getKey());
        assertEquals(3, tree.getRoot().getOneNode().getOneNode().getKey());
        assertEquals(9, tree.getRoot().getOneNode().getZeroNode().getZeroNode().getKey());
        assertEquals(21, tree.getRoot().getOneNode().getZeroNode().getOneNode().getKey());
    }

    @Test
    public void should_find() {
        assertEquals("5", tree.find(5));
        assertEquals("6", tree.find(6));
        assertEquals("7", tree.find(7));
        assertEquals("18", tree.find(18));
        assertEquals("13", tree.find(13));
        assertEquals("3", tree.find(3));
        assertEquals("9", tree.find(9));
        assertEquals("21", tree.find(21));
        assertEquals(null, tree.find(53));
    }
   
    private void fill() {
        tree.insert(5, "5");
        tree.insert(6, "6");
        tree.insert(7, "7");
        tree.insert(18, "18");
        tree.insert(13, "13");
        tree.insert(9, "9");
        tree.insert(3, "3");
        tree.insert(21, "21");
    }
}
