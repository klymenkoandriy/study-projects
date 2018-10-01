package com.sigmaukraine.aklymenko.bench.sort;

import java.util.Random;

/**
 * @author Andriy Klymenko
 */
public abstract class AbstractSorter implements Sorter {

    private static final int INITIAL_SIZE = 8;

    private static Random random = new Random();

    protected int[] values;
    protected int size;

    /**
     * Default constructor.
     */
    public AbstractSorter() {
    }

    /**
     * Constructor.
     *
     * @param values values.
     */
    public AbstractSorter(int[] values) {
        this.values = values;
        this.size = values.length;
    }

    /**
     * Constructor with size.
     * Size must be greater then 0.
     *
     * @param size size
     */
    public AbstractSorter(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater then 0.");
        }
        values = new int[size];
        this.size = size;
    }

    @Override
    public int[] getValues() {
        return values;
    }

    @Override
    public void setValues(int[] values) {
        if (values == null) {
            throw new IllegalArgumentException("Argument mustn't be null.");
        }
        this.values = values;
        size = values.length;
    }

    @Override
    public long sort() {
        if (values == null) {
            throw new RuntimeException("Array is null!");
        }
        return performSort();
    };

    /**
     * Performs sorting.
     *
     * @return time(ms)
     */
    public abstract long performSort();

}
