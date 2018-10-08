package com.sigmaukraine.aklymenko.bench.sort;

public class CountingSorter  extends AbstractSorter implements Sorter {

    int maxValue;
    
    int[] countValues;
    
    @Override
    public void setValues(int[] values) {
        super.setValues(values);
        for(int value : values) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        countValues = new int[maxValue + 1];
        
    }
    
    @Override
    public long performSort() {
        long start = System.nanoTime();

        for(int value : values) {
            countValues[value]++;
        }
        
        int index = 0;
        for(int i = 0; i < countValues.length; i++) {
            for (int j = 0; j < countValues[i]; j++) {
                values[index++] = i;
            }
        }
        // TODO Auto-generated method stub
        return System.nanoTime() - start;
    }

}
