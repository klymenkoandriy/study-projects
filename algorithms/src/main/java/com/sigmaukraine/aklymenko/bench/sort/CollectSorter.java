package com.sigmaukraine.aklymenko.bench.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Andriy Klymenko
 */
public class CollectSorter extends AbstractSorter implements Sorter {

    @Override
    public long performSort() {

        List<Integer> list = Arrays.stream(values).boxed().collect(Collectors.toList());

        long start = System.nanoTime();
        Collections.sort(list);
        long end = System.nanoTime();

        values = list.stream().mapToInt(i -> i).toArray();
        return end - start;
    }

}
