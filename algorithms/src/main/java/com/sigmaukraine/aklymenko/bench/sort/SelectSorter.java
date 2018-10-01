package com.sigmaukraine.aklymenko.bench.sort;

/**
 * @author Andriy Klymenko
 */
public class SelectSorter extends Sorter {

    @Override
    public long sort() {
        int tmp = 0;
        long start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            int least = i;
            for (int j = i + 1; j < size; j++) {
                if (values[j] < values[least]) {
                    least = j;
                }
            }

            tmp = values[i];
            values[i] = values[least];
            values[least] = tmp;
        }

        return System.nanoTime() - start;
    }
}
