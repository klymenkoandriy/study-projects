package com.sigmaukraine.aklymenko.bench;

import com.sigmaukraine.aklymenko.bench.sort.ArraysSorter;
import com.sigmaukraine.aklymenko.bench.sort.BubbleSorter;
import com.sigmaukraine.aklymenko.bench.sort.CollectSorter;
import com.sigmaukraine.aklymenko.bench.sort.InsertSorter;
import com.sigmaukraine.aklymenko.bench.sort.MergeSorter;
import com.sigmaukraine.aklymenko.bench.sort.QuickSorter;
import com.sigmaukraine.aklymenko.bench.sort.SelectSorter;
import com.sigmaukraine.aklymenko.bench.sort.Sorter;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Andriy Klymenko
 */
public final class MainAlgorithms {

    private static final int MAX_NAME_LENGTH = 15;

    private static Map<Long, String> testResults;

    private MainAlgorithms() {
    }

    /**
     * Main.
     *
     * @param args arguments
     */
    public static void main(String[] args) {

        int size = 10;
        testSorting(size);

        size *= 1000;
        testSorting(size);
    }

    private static void testSorting(int size) {
        System.out.println(" -------- Sort " + size + " items. Time(ns):");
        testResults = new TreeMap<>();

        testSorter(new ArraysSorter(size));
        testSorter(new BubbleSorter(size));
        testSorter(new SelectSorter(size));
        testSorter(new InsertSorter(size));
        testSorter(new QuickSorter(size));
        testSorter(new CollectSorter(size));
        testSorter(new MergeSorter(size));

        for (Map.Entry entry : testResults.entrySet()) {
            System.out.print(entry.getValue() + ": ");
            System.out.println(entry.getKey());
        }
    }

    private static void testSorter(Sorter sorter) {
        sorter.fillRandom();
        long time = sorter.sort();
        testResults.put(time, getName(sorter));
    }

    private static String getName(Sorter sorter) {
        String name = sorter.getClass().getSimpleName();
        int addLength = name.length() < MAX_NAME_LENGTH ? MAX_NAME_LENGTH - name.length() : 1;
        String spaces = String.format("%0" + addLength + "d", 0).replace('0', ' ');
        return name + spaces;
    }
}
