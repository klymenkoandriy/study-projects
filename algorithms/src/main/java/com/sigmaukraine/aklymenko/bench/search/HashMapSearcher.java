package com.sigmaukraine.aklymenko.bench.search;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Andriy Klymenko
 *
 */
public class HashMapSearcher extends AbstractSearcher implements Searcher {

    private Map<Integer, String> itemsMap;

    @Override
    public void setItems(Item[] items) {
        super.setItems(items);
        createHashMap();
    }

    private void createHashMap() {
        itemsMap = new HashMap<>();
        for (Item item : items) {
            itemsMap.put(item.getKey(), item.getValue());
        }
    }

    @Override
    public String find(int key) {
        return itemsMap.get(key);
    }

}
