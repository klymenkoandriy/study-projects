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
        values = new int[] {62, 21, 53, 2, 0, 4};
    }

    @Test
    public void should_sort_correctly_bubble_sorting() {
        testSorting(new BubbleSorter());
    }

    @Test
    public void should_sort_correctly_insert_sorting() {
        testSorting(new InsertSorter());
    }

    @Test
    public void should_sort_correctly_merge_sorting() {
        testSorting(new MergeSorter());
    }

    @Test
    public void should_sort_correctly_quick_sorting() {
        testSorting(new QuickSorter());
    }

    @Test
    public void should_sort_correctly_select_sorting() {
        testSorting(new SelectSorter());
    }

    @Test
    public void should_sort_correctly_shell_sorting() {
        testSorting(new ShellSorter());
    }

    @Test
    public void should_sort_correctly_shell_khnut_sorting() {
        testSorting(new ShellSorterKhnut());
    }

    @Test
    public void should_sort_correctly_radix_sorting() {
        testSorting(new RadixSorter());
    }

    @Test
    public void should_sort_correctly_cocktail_sorting() {
        testSorting(new CocktailSorter());
    }

    @Test
    public void should_sort_correctly_bucket_sorting() {
        testSorting(new BucketSorter());
    }

    @Test
    public void should_sort_correctly_heap_sorting() {
        testSorting(new HeapSorter());
    }

    private void testSorting(Sorter sorter) {
        sorter.setValues(values);
        sorter.sort();

        for (int i = 1; i < values.length; i++) {
            assertTrue(values[i - 1] <= values[i]);
        }
    }
}
