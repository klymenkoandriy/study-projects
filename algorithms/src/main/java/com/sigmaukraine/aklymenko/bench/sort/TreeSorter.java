package com.sigmaukraine.aklymenko.bench.sort;

import com.sigmaukraine.aklymenko.bench.collections.tree.Tree;

/**
 * 
 * @author Andriy Klymenko
 *
 */
public class TreeSorter  extends AbstractSorter implements Sorter {

    private Tree<String> tree;

    @Override
    public void performSort() {
        tree = new Tree<>();
        for (int value : values) {
            tree.insert(value, "");
        }
        values = tree.getSortedKeys();
    }

}
