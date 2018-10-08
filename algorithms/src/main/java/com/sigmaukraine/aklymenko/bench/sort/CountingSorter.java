package com.sigmaukraine.aklymenko.bench.sort;

/**
 * 
 * @author Andriy Klymenko
 *
 */
public class CountingSorter  extends AbstractSorter implements Sorter {

    @Override
    public void performSort() {

        int maxValue = 0;
        for (int value : values) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        int[] countValues = new int[maxValue + 1];

        for (int value : values) {
            countValues[value]++;
        }

        int index = 0;
        for (int i = 0; i < countValues.length; i++) {
            for (int j = 0; j < countValues[i]; j++) {
                values[index++] = i;
            }
        }
    }

}
