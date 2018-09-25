package com.sigmaukraine.aklymenko.bench.sort;

import java.util.Random;

/**
 * @author Andriy Klymenko
 */
public abstract class Sorter {

    private static final int INITIAL_SIZE = 8;

    private static Random random = new Random();

    protected int[] values;
    protected int size;

    /**
     * Constructor with size.
     * Size must be greater then 0.
     *
     * @param size size
     */
    public Sorter(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater then 0.");
        }
        values = new int[size];
        this.size = size;
    }

    /**
     * Fills array with rendom values.
     */
    public void fillRandom() {
        for (int i = 0; i < size; i++) {
            values[i] = random.nextInt(values.length);
        }
    }

    public int[] getValues() {
        return values;
    }

    /**
     * Sets values.
     *
     * @param values input values
     */
    public void setValues(int[] values) {
        if (values == null) {
            throw new IllegalArgumentException("Argument mustn't be null.");
        }
        this.values = values;
        size = values.length;
    }

    /**
     * Sorts array.
     *
     * @return time(ms)
     */
    public abstract long sort();

}
