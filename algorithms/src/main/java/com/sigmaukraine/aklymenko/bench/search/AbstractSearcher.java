package com.sigmaukraine.aklymenko.bench.search;

import java.util.Arrays;

/**
 * 
 * @author Andriy Klymenko
 *
 */
public abstract class AbstractSearcher implements Searcher {

    protected Item[] items;
    protected long serchTime;

    @Override
    public Item[] getItems() {
        return items;
    }

    @Override
    public void setItems(Item[] items) {
        this.items = Arrays.copyOf(items, items.length);
        Arrays.sort(this.items);
    }

    @Override
    public String get(int key) {
        if (items == null) {
            throw new IllegalStateException("List items is null");
        }
        long start = System.nanoTime();
        String value = find(key);
        serchTime = System.nanoTime() - start;
        return value;
    }

    @Override
    public long getLastSerchTime() {
        return serchTime;
    }

    /**
     * Performs search.
     * 
     * @param key key
     * @return value
     */
    public abstract String find(int key);
}
