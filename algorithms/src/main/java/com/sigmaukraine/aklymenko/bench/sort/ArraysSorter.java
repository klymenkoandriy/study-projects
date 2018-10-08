package com.sigmaukraine.aklymenko.bench.sort;

import java.util.Arrays;

/**
 * @author Andriy Klymenko
 */
public class ArraysSorter extends AbstractSorter implements Sorter {

    @Override
    public void performSort() {
        Arrays.sort(values);
    }
}
