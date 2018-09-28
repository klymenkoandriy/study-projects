package com.sigmaukraine.aklymenko.bench.sort;

/**
 * @author Andriy Klymenko
 */
public class InsertSorter extends Sorter {

    @Override
    public long sort() {
        int tmp = 0;
        long start = System.nanoTime();
        for (int i = 1; i < size; i++) {
            tmp = values[i];
            int j = i - 1;
            while (j >= 0 && tmp < values[j]) {
                values[j + 1] = values[j];
                j--;
            }
            values[j + 1] = tmp;
        }

        return System.nanoTime() - start;
    }
}
