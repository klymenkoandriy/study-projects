package com.sigmaukraine.aklymenko.bench.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Andriy Klymenko
 */
public class BucketSorter extends AbstractSorter implements Sorter {

    private static final int MASK_SIZE = 4;
    private int mask = 1;

    private List<List<Integer>> buckets;

    @Override
    public void performSort() {
        initialize();

        for (int value : values) {
            if (value < 0) {
                throw new IllegalStateException("Negative data are not allowed!");
            }
            addToBucket(value);
        }

        sortBuckets();
        fillByResults();
    }

    private void fillByResults() {
        int i = 0;
        for (List<Integer> bucket : buckets) {
            for (Integer val : bucket) {
                values[i++] = val;
            }
        }
    }

    private void sortBuckets() {
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }
    }

    private void addToBucket(int value) {
        int index = value >> MASK_SIZE;
        if (buckets.size() <= index) {
            growList(index);
        }

        buckets.get(index).add(value);
    }

    private void growList(int maxIndex) {
        for (int i = buckets.size(); i <= maxIndex; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    private void initialize() {
        buckets = new ArrayList<>();

        for (int i = 1; i < MASK_SIZE; i++) {
            mask = (mask << 1) + 1;
        }

        buckets.add(new ArrayList<>());
    }
}
