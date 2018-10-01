package com.sigmaukraine.aklymenko.bench;

import com.sigmaukraine.aklymenko.bench.sort.ArraysSorter;
import com.sigmaukraine.aklymenko.bench.sort.BubbleSorter;
import com.sigmaukraine.aklymenko.bench.sort.CocktailSorter;
import com.sigmaukraine.aklymenko.bench.sort.CollectSorter;
import com.sigmaukraine.aklymenko.bench.sort.InsertSorter;
import com.sigmaukraine.aklymenko.bench.sort.MergeSorter;
import com.sigmaukraine.aklymenko.bench.sort.QuickSorter;
import com.sigmaukraine.aklymenko.bench.sort.RadixSorter;
import com.sigmaukraine.aklymenko.bench.sort.SelectSorter;
import com.sigmaukraine.aklymenko.bench.sort.ShellSorter;
import com.sigmaukraine.aklymenko.bench.sort.ShellSorterKhnut;
import com.sigmaukraine.aklymenko.bench.sort.Sorter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author Andriy Klymenko
 */
public final class MainAlgorithms {

    private static final int MAX_NAME_LENGTH = 17;
    private static final int SIZE = 10_000;
    private static final int SHOTS = 5;

    private static Random random = new Random();

    private static Map<String, List<Long>> testResults;

    private static int[] testedArray;

    private MainAlgorithms() {
    }

    /**
     * Main.
     *
     * @param args arguments
     */
    public static void main(String[] args) {
        System.out.print(" -------- Sort " + SIZE + " items (random data). Time(ns)  ");
        fillRandom();
        testSorting();

        System.out.print(" -------- Sort " + SIZE + " items (partly ordered data). Time(ns)  ");
        fillPartlyOrdered();
        testSorting();

        System.out.print(" -------- Sort " + SIZE + " items (ordered data). Time(ns)  ");
        fillOrdered();
        testSorting();
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

        System.out.println();

        Map<String, Long> avgResults = getAverageResults();
        showResults(avgResults);
    }

    private static void testSorter(Sorter sorter) {
        System.out.print("/");
        String name = getName(sorter);

        List<Long> classResults = testResults.get(name);
        if (classResults == null) {
            classResults = new ArrayList<>();
            testResults.put(name, classResults);
        }
        for (int i = 0; i <= SHOTS; i++) {
            System.out.print(".");

            sorter.setValues(getFilledArray());

            long time = sorter.sort();
            checkOrderedValues(sorter.getValues());

            if (i > 0) {
                classResults.add(time);
            }
        }

        //System.out.println(Arrays.toString(sorter.getValues()));
    }

    private static int[] getFilledArray() {
        return Arrays.copyOf(testedArray, testedArray.length);
    }

    private static void fillOrdered() {
        testedArray = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            testedArray[i] = i;
        }
    }

    private static void fillPartlyOrdered() {
        testedArray = new int[SIZE];
        for (int i = 0; i < SIZE / 2; i++) {
            testedArray[i] = i;
        }
        for (int i = SIZE / 2; i < SIZE; i++) {
            testedArray[i] = random.nextInt(SIZE);
        }
    }

    private static void fillRandom() {
        testedArray = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            testedArray[i] = random.nextInt(SIZE);
        }
    }

    private static Map<String, Long> getAverageResults() {
        Map<String, Long> avgResults = new HashMap<>();

        testResults.forEach((k, results) -> {
            long tmp = 0;
            for (long res : results) {
                tmp += res;
            }
            tmp /= results.size();
            avgResults.put(k, tmp);
        });

        return avgResults;
    }

    private static void showResults(Map<String, Long> results) {
        List<Map.Entry<String, Long>> res = new ArrayList<>(results.entrySet());
        res.sort(new Comparator<Map.Entry<String, Long>>() {
            @Override
            public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
                long diff = o1.getValue() - o2.getValue();
                return diff < 0 ? -1 : (diff > 0 ? 1 : 0);
            }
        });

        res.forEach(entry -> {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        });
    }

    private static String getName(Sorter sorter) {
        String name = sorter.getClass().getSimpleName();
        int addLength = name.length() < MAX_NAME_LENGTH ? MAX_NAME_LENGTH - name.length() : 1;
        String spaces = String.format("%0" + addLength + "d", 0).replace('0', ' ');
        return name + spaces;
    }

    private static void checkOrderedValues(final int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            boolean b = arr[i - 1] > arr[i];
            assert arr[i - 1] <= arr[i] : "Not ordered!";
        }
    }

}
