package com.sigmaukraine.aklymenko.bench.search;

/**
 * 
 * @author Andriy Klymenko
 *
 */
public class IndexSearcher extends AbstractSearcher implements Searcher {

    private int blockSize;

    private Index[] indexes;

    @Override
    public void setItems(Item[] items) {
        super.setItems(items);
        createIndexes();
    }

    private void createIndexes() {
        int indexSize = (int) Math.ceil(Math.sqrt((double) items.length));

        indexes = new Index[indexSize];
        blockSize = (int) Math.ceil((double)items.length / indexSize);
        for (int i = 0; i < indexSize; i++) {
            int indexKey = items[i * blockSize].getKey();
            int indexLink = i * blockSize;
            indexes[i] = new Index(indexKey, indexLink);
        }
    }

    @Override
    public String find(int key) {
        Integer startLink = null;
        for (Index index : indexes) {
            if (key >= index.key) {
                startLink = index.link;
            } else {
                break;
            }
        }

        if (startLink != null) {
            for (int i = startLink; i <= startLink + blockSize; i++) {
                Item item = items[i];
                if (key == item.getKey()) {
                    return item.getValue();
                }
            }
        }

        return null;
    }

    /**
     * Index class.
     * 
     * @author Andriy Klymenko
     */
    private final class Index {
        private int key;
        private int link;

        private Index(int key, int link) {
            this.key = key;
            this.link = link;
        }
    }
}
