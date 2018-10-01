package com.sigmaukraine.aklymenko.bench.sort;

/**
 * @author Andriy Klymenko
 */
public interface Sorter {

    /**
     * Returns values.
     *
     * @return values
     */
    int[] getValues();

    /**
     * Sets values.
     *
     * @param values values
     */
    void setValues(int[] values);

    /**
     * Sorts array.
     *
     * @return total time (ns)
     */
    long sort();

}
