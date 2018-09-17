package com.sigmaukraine.aklymenko.bench.collections.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Andriy Klymenko
 */
public final class TryList {

    private TryList() {
    }

    /**
     * Compares time of methods execution in List for LinkedList and ArrayList.
     */
    public static void compareLists() {

        LinkedList<Integer> linkedList = null;
        ArrayList<Integer> arrayList = null;

        LinkedList<Integer> copyLinkedList;
        ArrayList<Integer> copyArrayList;

        System.out.println("\n>>> compare LinkedList and ArrayList time");

        int amount = 10_000;
        int shots = 30;

        // insert
        System.out.println("\n--- insert: " + amount + ", average on: " + shots + ", time(ns): ");

        float linkedListTime = 0;
        float arrayListTime = 0;
        for (int i = 0; i < shots; i++) {
            linkedList = new LinkedList<>();
            linkedListTime += testListInsert(linkedList, amount);
        }
        linkedListTime = linkedListTime / shots;
        System.out.println("linkedList: " + linkedListTime);

        for (int i = 0; i < shots; i++) {
            arrayList = new ArrayList<>();
            arrayListTime += testListInsert(arrayList, amount);
        }
        arrayListTime = arrayListTime / shots;
        System.out.println("arrayList : " + arrayListTime);

        printCompereResult(linkedListTime, arrayListTime);

        // remove
        System.out.println("\n--- remove: " + amount + ", average on: " + shots + ", time(ns): ");

        linkedListTime = 0;
        for (int i = 0; i < shots; i++) {
            copyLinkedList = new LinkedList<>(linkedList);
            linkedListTime += testListRemove(copyLinkedList);
        }
        linkedListTime = linkedListTime / shots;
        System.out.println("linkedList: " + linkedListTime);

        arrayListTime = 0;
        for (int i = 0; i < shots; i++) {
            copyArrayList = new ArrayList<>(arrayList);
            arrayListTime += testListRemove(copyArrayList);
        }
        arrayListTime = arrayListTime / shots;
        System.out.println("arrayList : " + arrayListTime);

        printCompereResult(linkedListTime, arrayListTime);

        // get
        System.out.println("\n--- get: " + amount + ", average on: " + shots + ", time(ns): ");

        linkedListTime = 0;
        for (int i = 0; i < shots; i++) {
            linkedListTime += testListGet(linkedList);
        }
        linkedListTime = linkedListTime / shots;
        System.out.println("linkedList: " + linkedListTime);

        arrayListTime = 0;
        for (int i = 0; i < shots; i++) {
            arrayListTime += testListGet(arrayList);
        }
        arrayListTime = arrayListTime / shots;
        System.out.println("arrayList : " + arrayListTime);

        printCompereResult(linkedListTime, arrayListTime);
    }

    private static long testListInsert(List<Integer> testList, int amount) {
        long start = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            testList.add(0, i);
        }
        return  System.nanoTime() - start;
    }

    private static long testListRemove(List testList) {
        int size = testList.size();
        long start = System.nanoTime();
        for (int i = 1; i < size; i++) {
            testList.remove(0);
        }
        return  System.nanoTime() - start;
    }

    private static long testListGet(List testList) {
        long start = System.nanoTime();
        for (int i = 0; i < testList.size(); i++) {
            testList.get(i);
        }
        return  System.nanoTime() - start;
    }

    private static void printCompereResult(float linkedListTime, float arrayListTime) {
        if (linkedListTime > arrayListTime) {
            System.out.println("arrayList < linkedList: " + linkedListTime / arrayListTime);
        } else {
            System.out.println("arrayList > linkedList: " + arrayListTime / linkedListTime);
        }
        return;
    }

}
