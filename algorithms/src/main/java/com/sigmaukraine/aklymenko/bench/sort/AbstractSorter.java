package com.sigmaukraine.aklymenko.bench.sort;

/**
 * @author Andriy Klymenko
 */
public abstract class AbstractSorter implements Sorter {

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
        setValues(values);
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

        long start = System.nanoTime();
        performSort();

        return System.nanoTime() - start;
    };

    /**
     * Performs sorting.
     */
    public abstract void performSort();

}
