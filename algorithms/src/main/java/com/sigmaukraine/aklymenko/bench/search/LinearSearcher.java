package com.sigmaukraine.aklymenko.bench.search;

/**
 * 
 * @author Andriy Klymenko
 *
 */
public class LinearSearcher extends AbstractSearcher implements Searcher {

    @Override
    public String find(int key) {
        String result = null;
        for (Item item : items) {
            if (item.getKey() == key) {
                result = item.getValue();
                break;
            }
        }
        return result;
    }

}
