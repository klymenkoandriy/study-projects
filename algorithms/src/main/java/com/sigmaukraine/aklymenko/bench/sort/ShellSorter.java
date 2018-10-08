package com.sigmaukraine.aklymenko.bench.sort;

/**
 * @author Andriy Klymenko
 */
public class ShellSorter extends AbstractSorter implements Sorter {

    protected int step;

    /**
     * Initializes step.
     */
    protected void initStep() {
        //Search start (maximum) step size by Shell
        step = size / 2;
    }

    /**
     * Calculates next step.
     */
    protected void nextStep() {
        step = step / 2;
    }

    @Override
    public void performSort() {
        int i;
        int j;
        int temp;
        initStep();

        while (step > 0) {
            for (i = step; i < values.length; i++) {
                temp = values[i];
                for (j = i; j >= step; j -= step) {
                    if (temp < values[j - step]) {
                        values[j] = values[j - step];
                    } else {
                        break;
                    }
                }
                values[j] = temp;
            }
            nextStep();
        }
    }
}
