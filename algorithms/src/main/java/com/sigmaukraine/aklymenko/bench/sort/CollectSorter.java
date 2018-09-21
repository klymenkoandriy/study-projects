package com.sigmaukraine.aklymenko.bench.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Andriy Klymenko
 */
public class CollectSorter extends Sorter {

    /**
     * Constructor.
     *
     * @param size size
     */
    public CollectSorter(int size) {
        super(size);
    }

    @Override
    public long sort() {

        List<Integer> list = Arrays.stream(values).boxed().collect(Collectors.toList());

        long start = System.nanoTime();
        Collections.sort(list);
        long end = System.nanoTime();

        values = list.stream().mapToInt(i -> i).toArray();
        return end - start;
    }

}
