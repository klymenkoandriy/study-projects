package com.sigmaukraine.aklymenko.bench.sort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Andriy Klymenko
 */
public class SorterTest {

    private int[] values;

    @Before
    public void init() {
        values = new int[] {6, 2, 5, 3, 4};
    }

    @Test
    public void should_sort_correctly_bubble_sorting() {
        testSorting(new BubbleSorter(values.length));
    }

    @Test
    public void should_sort_correctly_insert_sorting() {
        testSorting(new InsertSorter(values.length));
    }

    @Test
    public void should_sort_correctly_merge_sorting() {
        testSorting(new MergeSorter(values.length));
    }

    @Test
    public void should_sort_correctly_quick_sorting() {
        testSorting(new QuickSorter(values.length));
    }

    @Test
    public void should_sort_correctly_select_sorting() {
        testSorting(new SelectSorter(values.length));
    }

    private void testSorting(Sorter sorter) {
        sorter.setValues(values);
        sorter.sort();

        for (int i = 1; i < values.length; i++) {
            assertTrue(values[i - 1] < values[i]);
        }
    }
}
