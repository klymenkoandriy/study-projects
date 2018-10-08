package com.sigmaukraine.aklymenko.bench.sort;

/**
 * @author Andriy Klymenko
 */
public class CocktailSorter extends AbstractSorter implements Sorter {

    @Override
    public void performSort() {
        int tmp;
        int left = 0;
        int right = values.length - 1;
        do {
            for (int i = left; i < right; i++) {
                if (values[i] > values[i + 1]) {
                    tmp = values[i];
                    values[i] = values[i + 1];
                    values[i + 1] = tmp;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (values[i] < values[i - 1]) {
                    tmp = values[i];
                    values[i] = values[i - 1];
                    values[i - 1] = tmp;
                }
            }
            left++;
        } while (left < right);
    }
}
