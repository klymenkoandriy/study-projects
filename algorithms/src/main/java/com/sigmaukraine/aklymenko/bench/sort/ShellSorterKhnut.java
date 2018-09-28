package com.sigmaukraine.aklymenko.bench.sort;

/**
 * @author Andriy Klymenko
 */
public class ShellSorterKhnut extends ShellSorter {

    @Override
    protected void initStep() {
        //Search start (maximum) step size by Khnut
        while (step <= size / 3) {
            step = step * 3 + 1;
        }
    }

    @Override
    protected void nextStep() {
        step = (step - 1) / 3;
    }
}
