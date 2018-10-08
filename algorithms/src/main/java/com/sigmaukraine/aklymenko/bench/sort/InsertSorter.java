package com.sigmaukraine.aklymenko.bench.sort;

/**
 * @author Andriy Klymenko
 */
public class InsertSorter extends AbstractSorter implements Sorter {

    @Override
    public void performSort() {
        int tmp = 0;
        for (int i = 1; i < size; i++) {
            tmp = values[i];
            int j = i - 1;
            while (j >= 0 && tmp < values[j]) {
                values[j + 1] = values[j];
                j--;
            }
            values[j + 1] = tmp;
        }
    }
}
