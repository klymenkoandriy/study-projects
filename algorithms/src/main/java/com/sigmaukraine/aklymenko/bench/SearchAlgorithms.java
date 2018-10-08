package com.sigmaukraine.aklymenko.bench;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.sigmaukraine.aklymenko.bench.search.BinarySearcher;
import com.sigmaukraine.aklymenko.bench.search.DSTreeSearcher;
import com.sigmaukraine.aklymenko.bench.search.HashMapSearcher;
import com.sigmaukraine.aklymenko.bench.search.IndexSearcher;
import com.sigmaukraine.aklymenko.bench.search.Item;
import com.sigmaukraine.aklymenko.bench.search.LinearSearcher;
import com.sigmaukraine.aklymenko.bench.search.Searcher;
import com.sigmaukraine.aklymenko.bench.util.AlgorithmsUtil;

/**
 * Class for testing the efficiency of search algorithms.
 * 
 * @author Andriy Klymenko
 *
 */
public final class SearchAlgorithms {

    private static final int MAX_NAME_LENGTH = 17;
    private static final int SEARCH_SHOTS = 20;

    private static Item[] testedItems;
    private static Map<String, List<Long>> testResults;

    private static Random random = new Random();

    private SearchAlgorithms() {
    }

    /**
     * Checks the effectiveness of search algorithms.
     * 
     * @param items items
     */
    static void testSearch(Item[] items) {
        testedItems = items;
        testResults = new HashMap<>();

        testSearcher(new LinearSearcher());
        testSearcher(new BinarySearcher());
        testSearcher(new IndexSearcher());
        testSearcher(new HashMapSearcher());
        testSearcher(new DSTreeSearcher());

        System.out.println();

        Map<String, Long> avgResults = AlgorithmsUtil.getAverageResults(testResults);
        AlgorithmsUtil.showResults(avgResults);
    }

    private static void testSearcher(Searcher searcher) {
        System.out.print("/");
        String name = AlgorithmsUtil.getName(searcher, MAX_NAME_LENGTH);

        List<Long> classResults = testResults.get(name);
        if (classResults == null) {
            classResults = new ArrayList<>();
            testResults.put(name, classResults);
        }
        for (int i = 0; i <= SEARCH_SHOTS; i++) {
            if (i % (SEARCH_SHOTS / 5) == 0) {
                System.out.print(".");
            }

            searcher.setItems(testedItems);

            int keyForSearch = testedItems[random.nextInt(testedItems.length)].getKey();
            String result = searcher.get(keyForSearch);
            assert String.valueOf(keyForSearch).equals(result);

            long time = searcher.getLastSerchTime();

            if (i > 0) {
                testResults.get(name).add(time);
            }
        }
    }

}
