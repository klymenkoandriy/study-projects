package com.sigmaukraine.aklymenko.bench.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.sigmaukraine.aklymenko.bench.search.Item;

/**
 * 
 * @author Andriy Klymenko
 *
 */
public final class AlgorithmsUtil {

    private static Random random = new Random();

    private AlgorithmsUtil() {
    }

    /**
     * Returns array that filled with ordered data.
     * 
     * @param size size
     * @return filled array
     */
    public static int[] getOrdered(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    /**
     * Returns array that filled for 50% with ordered data and 50% with random data.
     * 
     * @param size size
     * @return filled array
     */
    public static int[] getPartlyOrdered(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size / 2; i++) {
            array[i] = i;
        }
        for (int i = size / 2; i < size; i++) {
            array[i] = random.nextInt(size);
        }
        return array;
    }

    /**
     * Returns array that filled with random data.
     * 
     * @param size size
     * @return filled array
     */
    public static int[] getRandom(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size * 10);
        }
        return array;
    }

    /**
     * Returns list of Items that filled with random unique data.
     * 
     * @param size size
     * @return filled array
     */
    public static Item[] getRandomItems(int size) {
        Set<Item> items = new HashSet<>();

        while (items.size() < size) {
            int key = random.nextInt(size * 10);
            items.add(new Item(key, String.valueOf(key)));
        }
        return items.toArray(new Item[items.size()]);
    }

    /**
     * Check whether array contains sorted data.
     * 
     * @param array checked array
     */
    public static void checkSortedValues(final int[] array) {
        for (int i = 1; i < array.length; i++) {
            assert array[i - 1] <= array[i] : "Not ordered!";
        }
    }

    /**
     * Returns formatted class name.
     * 
     * @param object object
     * @param size expected String length
     * @return name
     */
    public static String getName(Object object, int size) {
        String name = object.getClass().getSimpleName();
        int addLength = name.length() < size ? size - name.length() : 1;
        String spaces = String.format("%0" + addLength + "d", 0).replace('0', ' ');
        return name + spaces;
    }

    /**
     * Returns average results.
     * 
     * @param testResults input results
     * @return average results
     */
    public static Map<String, Long> getAverageResults(Map<String, List<Long>> testResults) {
        Map<String, Long> avgResults = new HashMap<>();

        testResults.forEach((k, results) -> {
            long tmp = 0;
            for (long res : results) {
                tmp += res;
            }
            tmp /= results.size();
            avgResults.put(k, tmp);
        });

        return avgResults;
    }

    /**
     * Prints results.
     * 
     * @param results results to show
     */
    public static void showResults(Map<String, Long> results) {
        List<Map.Entry<String, Long>> res = new ArrayList<>(results.entrySet());
        res.sort(new Comparator<Map.Entry<String, Long>>() {
            @Override
            public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
                long diff = o1.getValue() - o2.getValue();
                return diff < 0 ? -1 : (diff > 0 ? 1 : 0);
            }
        });

        long maxVal = res.get(res.size() - 1).getValue();

        res.forEach(entry -> {
            System.out.println(entry.getKey() + ": " + convertResult(entry.getValue(), maxVal));
        });
    }

    private static String convertResult(long value, long max) {
        String stringMax = String.valueOf(max);
        String stringVal = String.valueOf(value);

        int diff = stringMax.length() - stringVal.length();

        if (diff > 0) {
            stringVal = String.format("%0" + diff + "d", 0).replace('0', ' ') + stringVal;
        }

        return stringVal;
    }

    /**
     * Returns <code>true</code> if the bit is set to a certain position.
     * 
     * @param value value
     * @param position position
     * @return <code>true</code> if the bit is set
     */
    public static boolean isBitSet(int value, int position) {
        return ((1 << position) & value) != 0;
    }
}
