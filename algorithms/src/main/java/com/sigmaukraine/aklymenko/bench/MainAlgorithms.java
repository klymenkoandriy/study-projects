package com.sigmaukraine.aklymenko.bench;

import com.sigmaukraine.aklymenko.bench.search.Item;
import com.sigmaukraine.aklymenko.bench.util.AlgorithmsUtil;

/**
 * @author Andriy Klymenko
 */
public final class MainAlgorithms {

    private static final int SORT_SIZE = 10_000;
    private static final int SEARCH_SIZE = 100_000;
    private static final int RANGE = 10;

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
        SortAlgorithms.testSorting(testedArray);

        System.out.print(" -------- Sort " + SORT_SIZE + " items (random data in gange 1.." + RANGE + "). Time(ns)  ");
        testedArray = AlgorithmsUtil.getRandom(SORT_SIZE, RANGE);
        SortAlgorithms.testSorting(testedArray);

        System.out.print(" -------- Sort " + SORT_SIZE + " items (partly ordered data). Time(ns)  ");
        testedArray = AlgorithmsUtil.getPartlyOrdered(SORT_SIZE);
        SortAlgorithms.testSorting(testedArray);

        System.out.print(" -------- Sort " + SORT_SIZE + " items (ordered data). Time(ns)  ");
        testedArray = AlgorithmsUtil.getOrdered(SORT_SIZE);
        SortAlgorithms.testSorting(testedArray);

        System.out.println("------- finish sorting-------------------------------------\n");

        System.out.print("-------- Search Time(ns)  ");
        testedItems = AlgorithmsUtil.getRandomItems(SEARCH_SIZE);
        SearchAlgorithms.testSearch(testedItems);

        System.out.println("------- finish search--------------------------------------");
    }

}
