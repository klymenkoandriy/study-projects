package com.sigmaukraine.aklymenko.bench;

import com.sigmaukraine.aklymenko.bench.sort.ArraysSorter;
import com.sigmaukraine.aklymenko.bench.sort.BubbleSorter;
import com.sigmaukraine.aklymenko.bench.sort.CollectSorter;
import com.sigmaukraine.aklymenko.bench.sort.InsertSorter;
import com.sigmaukraine.aklymenko.bench.sort.QuickSorter;
import com.sigmaukraine.aklymenko.bench.sort.SelectSorter;
import com.sigmaukraine.aklymenko.bench.sort.Sorter;

/**
 * @author Andriy Klymenko
 */
public final class MainAlgorithms {

    private static final int MAX_NAME_LENGTH = 15;

    private MainAlgorithms() {
    }

    /**
     * Main.
     *
     * @param args arguments
     */
    public static void main(String[] args) {

        int size = 10;

        System.out.println(" -------- Sort " + size + " items. Time(ns):");

        testSorting(new ArraysSorter(size));
        testSorting(new BubbleSorter(size));
        testSorting(new SelectSorter(size));
        testSorting(new InsertSorter(size));
        testSorting(new QuickSorter(size));
        testSorting(new CollectSorter(size));
    }

    private static void testSorting(Sorter sorter) {
        sorter.fillRandom();
//        System.out.println(Arrays.toString(sorter.getValues()));

        long time = sorter.sort();
//        System.out.println(Arrays.toString(sorter.getValues()));

        System.out.print(getName(sorter) + ": ");
        System.out.println(time);
    }

    private static String getName(Sorter sorter) {
        String name = sorter.getClass().getSimpleName();
        int addLength = name.length() < MAX_NAME_LENGTH ? MAX_NAME_LENGTH - name.length() : 1;
        String spaces = String.format("%0" + addLength + "d", 0).replace('0', ' ');
        return name + spaces;
    }
}
