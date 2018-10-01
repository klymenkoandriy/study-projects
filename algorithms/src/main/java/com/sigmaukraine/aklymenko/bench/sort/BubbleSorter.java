package com.sigmaukraine.aklymenko.bench.sort;

/**
 * @author Andriy Klymenko
 */
public final class BubbleSorter extends AbstractSorter implements Sorter {

    @Override
    public long performSort() {
        int tmp = 0;

        long start = System.nanoTime();
        for (int i = 0;  i < size; i++) {
            for (int j = 1;  j < size - i; j++) {
                if (values[j - 1] > values[j]) {
                    tmp = values[j];
                    values[j] = values[j - 1];
                    values[j - 1] = tmp;
                }
            }
        }

        return System.nanoTime() - start;
    }
}
