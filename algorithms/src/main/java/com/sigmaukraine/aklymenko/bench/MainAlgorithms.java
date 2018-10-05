package com.sigmaukraine.aklymenko.bench;

import com.sigmaukraine.aklymenko.bench.search.BinarySearcher;
import com.sigmaukraine.aklymenko.bench.search.HashMapSearcher;
import com.sigmaukraine.aklymenko.bench.search.IndexSearcher;
import com.sigmaukraine.aklymenko.bench.search.Item;
import com.sigmaukraine.aklymenko.bench.search.LinearSearcher;
import com.sigmaukraine.aklymenko.bench.search.Searcher;
import com.sigmaukraine.aklymenko.bench.sort.ArraysSorter;
import com.sigmaukraine.aklymenko.bench.sort.BubbleSorter;
import com.sigmaukraine.aklymenko.bench.sort.BucketSorter;
import com.sigmaukraine.aklymenko.bench.sort.CocktailSorter;
import com.sigmaukraine.aklymenko.bench.sort.CollectSorter;
import com.sigmaukraine.aklymenko.bench.sort.HeapSorter;
import com.sigmaukraine.aklymenko.bench.sort.InsertSorter;
import com.sigmaukraine.aklymenko.bench.sort.MergeSorter;
import com.sigmaukraine.aklymenko.bench.sort.QuickSorter;
import com.sigmaukraine.aklymenko.bench.sort.RadixSorter;
import com.sigmaukraine.aklymenko.bench.sort.SelectSorter;
import com.sigmaukraine.aklymenko.bench.sort.ShellSorter;
import com.sigmaukraine.aklymenko.bench.sort.ShellSorterKhnut;
import com.sigmaukraine.aklymenko.bench.sort.Sorter;
import com.sigmaukraine.aklymenko.bench.util.AlgorithmsUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author Andriy Klymenko
 */
public final class MainAlgorithms {

    private static final int MAX_NAME_LENGTH = 17;
    private static final int SORT_SIZE = 10_000;
    private static final int SORT_SHOTS = 5;
    private static final int SEARCH_SIZE = 100_000;
    private static final int SEARCH_SHOTS = 20;

    private static Random random = new Random();

    private static Map<String, List<Long>> testResults;

    private static int[] testedArray;
    private static Item[] testedItems;

    private MainAlgorithms() {
    }

    /**
     * Main.
     *
     * @param args arguments
     */
    public static void main(String[] args) {
        System.out.print(" -------- Sort " + SORT_SIZE + " items (random data). Time(ns)  ");
        testedArray = AlgorithmsUtil.getRandom(SORT_SIZE);
        testSorting();

        System.out.print(" -------- Sort " + SORT_SIZE + " items (partly ordered data). Time(ns)  ");
        testedArray = AlgorithmsUtil.getPartlyOrdered(SORT_SIZE);
        testSorting();

        System.out.print(" -------- Sort " + SORT_SIZE + " items (ordered data). Time(ns)  ");
        testedArray = AlgorithmsUtil.getOrdered(SORT_SIZE);
        testSorting();

        System.out.println("------- finish sorting-------------------------------------\n");

        System.out.print("-------- Search Time(ns)  ");
        testedItems = AlgorithmsUtil.getRandomItems(SEARCH_SIZE);
        testSearch();

        System.out.println("------- finish search--------------------------------------");
    }

    private static void testSorting() {

        testResults = new HashMap<>();

        testSorter(new ArraysSorter());
        testSorter(new BubbleSorter());
        testSorter(new SelectSorter());
        testSorter(new InsertSorter());
        testSorter(new QuickSorter());
        testSorter(new CollectSorter());
        testSorter(new MergeSorter());
        testSorter(new ShellSorter());
        testSorter(new ShellSorterKhnut());
        testSorter(new RadixSorter());
        testSorter(new CocktailSorter());
        testSorter(new BucketSorter());
        testSorter(new HeapSorter());

        System.out.println();

        Map<String, Long> avgResults = AlgorithmsUtil.getAverageResults(testResults);
        AlgorithmsUtil.showResults(avgResults);
    }

    private static void testSorter(Sorter sorter) {
        System.out.print("/");
        String name = AlgorithmsUtil.getName(sorter, MAX_NAME_LENGTH);

        List<Long> classResults = testResults.get(name);
        if (classResults == null) {
            classResults = new ArrayList<>();
            testResults.put(name, classResults);
        }
        for (int i = 0; i <= SORT_SHOTS; i++) {
            System.out.print(".");

            sorter.setValues(Arrays.copyOf(testedArray, testedArray.length));

            long time = sorter.sort();
            AlgorithmsUtil.checkSortedValues(sorter.getValues());

            if (i > 0) {
                testResults.get(name).add(time);
            }
        }
    }

    private static void testSearch() {
        testResults = new HashMap<>();

        testSearcher(new LinearSearcher());
        testSearcher(new BinarySearcher());
        testSearcher(new IndexSearcher());
        testSearcher(new HashMapSearcher());
        
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
