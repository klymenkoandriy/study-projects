package com.sigmaukraine.aklymenko.bench.search;

import java.util.HashMap;
import java.util.Map;

public class HashMapSearcher extends AbstractSearcher implements Searcher {

    private Map<Integer, String> itemsMap;
    
    @Override
    public void setItems(Item[] items) {
        super.setItems(items);
        createHashSet();
    }
    
    private void createHashSet() {
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
