package com.sigmaukraine.aklymenko.bench.search;

import com.sigmaukraine.aklymenko.bench.tree.DigitalSearchTree;

/**
 * 
 * @author Andriy Klymenko
 *
 */
public class DSTreeSearcher  extends AbstractSearcher implements Searcher {

    private DigitalSearchTree tree;

    @Override
    public void setItems(Item[] items) {
        super.setItems(items);
        buildTree();
    }

    private void buildTree() {
        tree = new DigitalSearchTree();
        for (Item item : items) {
            tree.insert(item.getKey(), item.getValue());
        }
    }

    @Override
    public String find(int key) {
        return tree.find(key);
    }

}
