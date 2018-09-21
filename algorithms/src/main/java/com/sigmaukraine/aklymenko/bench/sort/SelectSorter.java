package com.sigmaukraine.aklymenko.bench.sort;

/**
 * @author Andriy Klymenko
 */
public class SelectSorter extends Sorter {

    /**
     * Constructor.
     *
     * @param size size
     */
    public SelectSorter(int size) {
        super(size);
    }

    @Override
    public long sort() {
        int tmp = 0;
        long start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (values[j] < values[i]) {
                    tmp = values[i];
                    values[i] = values[j];
                    values[j] = tmp;
                }
            }
        }

        return System.nanoTime() - start;
    }
}
