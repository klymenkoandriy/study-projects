package com.sigmaukraine.aklymenko.bench.sort;

/**
 * @author Andriy Klymenko
 */
public class HeapSorter extends AbstractSorter implements Sorter {

    @Override
    public long performSort() {
        long startTime = System.nanoTime();
        buildHeap();
        sortHeap();
        return System.nanoTime() - startTime;
    }

    private void buildHeap() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            checkNode(size, i);
        }
    }

    private void checkNode(int max, int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = left + 1;

        if (left < max && values[left] > values[largest]) {
            largest = left;
        }

        if (right < max && values[right] > values[largest]) {
            largest = right;
        }

        if (largest != index) {
            int swap = values[index];
            values[index] = values[largest];
            values[largest] = swap;
            checkNode(max, largest);
        }
    }

    private void sortHeap() {
        for (int i = size - 1; i >= 0; i--) {
            int temp = values[i];
            values[i] = values[0];
            values[0] = temp;
            checkNode(i, 0);
        }
    }
}
