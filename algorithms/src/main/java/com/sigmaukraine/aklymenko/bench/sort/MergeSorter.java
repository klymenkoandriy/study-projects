package com.sigmaukraine.aklymenko.bench.sort;

/**
 * @author Andriy Klymenko
 */
public class MergeSorter extends AbstractSorter implements Sorter {

    @Override
    public long performSort() {
        long start = System.nanoTime();
        mergeSort(values, 0, size - 1);
        return System.nanoTime() - start;
    }

    private static void mergeSort(int[] elements, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(elements, low, mid);
            mergeSort(elements, mid + 1, high);
            merge(elements, low, mid, high);
        }
    }

    private static void merge(int[] subset, int low, int mid, int high) {

        int n = high - low + 1;
        int[] temp = new int[n];

        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid || j <= high) {
            if (i > mid) {
                temp[k++] = subset[j++];
            } else if (j > high) {
                temp[k++] = subset[i++];
            } else if (subset[i] < subset[j]) {
                temp[k++] = subset[i++];
            } else {
                temp[k++] = subset[j++];
            }
        }
        for (j = 0; j < n; j++) {
            subset[low + j] = temp[j];
        }
    }

}
