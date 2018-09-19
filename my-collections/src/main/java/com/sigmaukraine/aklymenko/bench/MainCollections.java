package com.sigmaukraine.aklymenko.bench;

import com.sigmaukraine.aklymenko.bench.collections.list.TryList;
import com.sigmaukraine.aklymenko.bench.collections.queue.TryQueue;
import com.sigmaukraine.aklymenko.bench.collections.tree.TryTrees;

/**
 * @author Andriy Klymenko
 */
public final class MainCollections {

    private MainCollections() {
    }

    /**
     * Main.
     *
     * @param args arguments
     */
    public static void main(String[] args) {
        TryQueue.tryMySimpleQueue();
        TryTrees.tryIntKeyTree();
        TryTrees.tryGenericKeyTree();
        TryTrees.testSearchTime();
        TryList.compareLists();
    }

}
