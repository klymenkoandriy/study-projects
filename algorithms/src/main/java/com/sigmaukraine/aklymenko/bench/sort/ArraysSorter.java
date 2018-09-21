package com.sigmaukraine.aklymenko.bench.sort;

import java.util.Arrays;

/**
 * @author Andriy Klymenko
 */
public class ArraysSorter extends Sorter {

    /**
     * Constructor.
     *
     * @param size size
     */
    public ArraysSorter(int size) {
        super(size);

    }

    @Override
    public long sort() {
        long start = System.nanoTime();
        Arrays.sort(values);
        return System.nanoTime() - start;
    }
}
