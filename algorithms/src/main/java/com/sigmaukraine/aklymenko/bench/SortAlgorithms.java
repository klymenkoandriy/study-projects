package com.sigmaukraine.aklymenko.bench;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sigmaukraine.aklymenko.bench.sort.ArraysSorter;
import com.sigmaukraine.aklymenko.bench.sort.BubbleSorter;
import com.sigmaukraine.aklymenko.bench.sort.BucketSorter;
import com.sigmaukraine.aklymenko.bench.sort.CocktailSorter;
import com.sigmaukraine.aklymenko.bench.sort.CollectSorter;
import com.sigmaukraine.aklymenko.bench.sort.CountingSorter;
import com.sigmaukraine.aklymenko.bench.sort.HeapSorter;
import com.sigmaukraine.aklymenko.bench.sort.InsertSorter;
import com.sigmaukraine.aklymenko.bench.sort.MergeSorter;
import com.sigmaukraine.aklymenko.bench.sort.QuickSorter;
import com.sigmaukraine.aklymenko.bench.sort.RadixSorter;
import com.sigmaukraine.aklymenko.bench.sort.SelectSorter;
import com.sigmaukraine.aklymenko.bench.sort.ShellSorter;
import com.sigmaukraine.aklymenko.bench.sort.ShellSorterKhnut;
import com.sigmaukraine.aklymenko.bench.sort.Sorter;
import com.sigmaukraine.aklymenko.bench.sort.TreeSorter;
import com.sigmaukraine.aklymenko.bench.util.AlgorithmsUtil;

/**
 * Class for testing the efficiency of sorting algorithms.
 * 
 * @author Andriy Klymenko
 *
 */
public final class SortAlgorithms {

    private static final int MAX_NAME_LENGTH = 17;
    private static final int SORT_SHOTS = 5;

    private static int[] testedArray;
    private static Map<String, List<Long>> testResults;

    private SortAlgorithms() {
    }

    /**
     * Checks the effectiveness of sorting algorithms.
     * 
     * @param array array for sorting
     */
    static void testSorting(int[] array) {
        testedArray = array;
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
        testSorter(new CountingSorter());
        testSorter(new TreeSorter());

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
}
