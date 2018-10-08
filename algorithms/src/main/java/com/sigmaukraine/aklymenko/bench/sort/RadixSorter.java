package com.sigmaukraine.aklymenko.bench.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andriy Klymenko
 */
public class RadixSorter extends AbstractSorter implements Sorter {

    private List<List<List<Byte>>> input = new ArrayList<>();
    private List<List<List<Byte>>> output = new ArrayList<>();
    private int maxSize;

    @Override
    public void performSort() {
        //including first group
        convertInputValues();

        for (int i = 1; i < maxSize; i++) {
            input = output;
            initOutput();
            groupByRadix(i);
        }

        convertResult();
    }

    private void groupByRadix(int i) {
        for (List<List<Byte>> groups :input) {
            for (List<Byte> digits : groups) {
                output.get(getDigitByPosition(digits, i)).add(digits);
            }
        }
    }

    private int getDigitByPosition(List<Byte> digits, int i) {
        if (digits.size() <= i) {
            return 0;
        } else {
            return digits.get(i);
        }
    }

    private void convertInputValues() {
        initOutput();

        for (int val : values) {
            List<Byte> digits = convertToBytes(val);
            int size = digits.size();
            if (size > maxSize) {
                maxSize = size;
            }
            output.get(digits.get(0)).add(digits);
        }
    }

    private List<Byte> convertToBytes(int val) {
        int tmpVal = val;
        List<Byte> digits = new ArrayList<>();
        while (tmpVal != 0) {
            byte digit = (byte) (tmpVal % 10);
            digits.add(digit);
            tmpVal /= 10;
        }
        if (digits.size() == 0) {
            digits.add((byte)0);
        }
        return digits;
    }

    private void initOutput() {
        output = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            output.add(new ArrayList<>());
        }
    }

    private void convertResult() {
        int i = 0;
        for (List<List<Byte>> vals :output) {
            for (List<Byte> digits :vals) {
                values[i++] = convertToInt(digits);
            }
        }
    }

    private int convertToInt(List<Byte> digits) {
        int factor = 1;
        int result = 0;

        for (byte val : digits) {
            result += val * factor;
            factor *= 10;
        }

        return result;
    }
}
