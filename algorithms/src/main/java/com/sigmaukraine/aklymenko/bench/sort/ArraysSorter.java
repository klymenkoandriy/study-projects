package com.sigmaukraine.aklymenko.bench.sort;

import java.util.Arrays;

/**
 * @author Andriy Klymenko
 */
public class ArraysSorter extends AbstractSorter implements Sorter {

    @Override
    public long performSort() {
        long start = System.nanoTime();
        Arrays.sort(values);
        return System.nanoTime() - start;
    }
}
