package com.sigmaukraine.aklymenko.bench.sort;

/**
 * @author Andriy Klymenko
 */
public class QuickSorter extends AbstractSorter implements Sorter {

    @Override
    public void performSort() {
        quickSort(0, size - 1);
    }

    private void quickSort(int leftIndex, int rightIndex) {

        int i = leftIndex;
        int j = rightIndex;
        int pivot = values[leftIndex + (rightIndex - leftIndex) / 2];

        while (i <= j) {

            while (values[i] < pivot) {
                i++;
            }
            while (values[j] > pivot) {
                j--;
            }

            if (i <= j) {
                exchangeNumbers(i, j);
                i++;
                j--;
            }
        }

        if (leftIndex < j) {
            quickSort(leftIndex, j);
        }
        if (i < rightIndex) {
            quickSort(i, rightIndex);
        }
    }

    private void exchangeNumbers(int i, int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

}
