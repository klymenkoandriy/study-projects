package com.sigmaukraine.aklymenko.bench.search;

/**
 * 
 * @author Andriy Klymenko
 *
 */
public interface Searcher {

    /**
     * Returns items.
     *
     * @return items
     */
    Item[] getItems();

    /**
     * Copies input values to the internal array and sorts it.
     *
     * @param items items
     */
    void setItems(Item[] items);

    /**
     * Returns item by key.
     *
     * @param key key
     * @return item
     */
    String get(int key);

    /**
     * Returns the duration of the last search.
     * 
     * @return time(ns)
     */
    long getLastSerchTime();
}
