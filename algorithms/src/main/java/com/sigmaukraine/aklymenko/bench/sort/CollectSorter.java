package com.sigmaukraine.aklymenko.bench.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Andriy Klymenko
 */
public class CollectSorter extends AbstractSorter implements Sorter {

    private List<Integer> listToSort;

    @Override
    public void setValues(int[] values) {
        super.setValues(values);
        listToSort = Arrays.stream(values).boxed().collect(Collectors.toList());
    }

    @Override
    public void performSort() {
        Collections.sort(listToSort);
        values = listToSort.stream().mapToInt(i -> i).toArray();
    }

}
