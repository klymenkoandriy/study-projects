package com.sigmaukraine.aklymenko.bench.search;

/**
 * 
 * @author Andriy Klymenko
 */
public class BinarySearcher extends AbstractSearcher implements Searcher {

    @Override
    public String find(int key) {
        Item item = null;
            int low = 0;
            int high = items.length;
            int mid;
            while (low < high) {
                mid = low + (high - low) / 2;
                item = items[mid];
                if (key == item.getKey()) {
                    break;
                } else {
                    if (key <= item.getKey()) {
                        high = mid;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        return item == null ? null : item.getValue();
    }

}
