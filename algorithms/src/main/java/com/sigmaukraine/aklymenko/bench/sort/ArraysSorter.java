package com.sigmaukraine.aklymenko.bench.sort;

import java.util.Arrays;

/**
 * @author Andriy Klymenko
 */
public class ArraysSorter extends Sorter {

    @Override
    public long sort() {
        long start = System.nanoTime();
        Arrays.sort(values);
        return System.nanoTime() - start;
    }
}
