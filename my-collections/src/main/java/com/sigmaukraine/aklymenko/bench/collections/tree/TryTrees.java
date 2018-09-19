package com.sigmaukraine.aklymenko.bench.collections.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Andriy Klymenko
 */
public final class TryTrees {

    private static final int COUNT = 100_000;
    private static final int SHOTS = 5;

    private static Random rand = new Random();

    private static Map<Integer, Integer> treeMap;
    private static Map<Integer, Integer> hashMap;
    private static GenericKeyTree<Integer, Integer> myGenTree;
    private static Tree<Integer> myIntTree;

    private static long[] times;

    private TryTrees() {
    }

    /**
     * Tree manual test.
     */
    public static void tryIntKeyTree() {
        System.out.println("\n>>> test Tree (int keys)");

        Tree<Integer> theTree = new Tree<>();

        theTree.insert(50, 50);
        theTree.insert(25, 25);
        theTree.insert(75, 75);
        theTree.insert(12, 12);
        theTree.insert(37, 37);
        theTree.insert(43, 43);
        theTree.insert(30, 30);
        theTree.insert(33, 33);

        theTree.delete(50);

        AtomicInteger count = new AtomicInteger(0);
        showIntKeyTree(theTree.getRoot(), count);
        System.out.println("Count: " + count);
    }

    private static void showIntKeyTree(Node node, AtomicInteger count) {

        Node leftNode = node.getLeft();
        Node rightNode = node.getRight();

        System.out.println(node);
        count.incrementAndGet();

        if (leftNode != null) {
            showIntKeyTree(leftNode, count);
        }

        if (rightNode != null) {
            showIntKeyTree(rightNode, count);
        }
    }

    /**
     * GenericKeyTree manual test.
     */
    public static void tryGenericKeyTree() {
        System.out.println("\n>>> test GenericKeyTree (String keys)");

        GenericKeyTree<String, Integer> theTree = new GenericKeyTree<>();

        theTree.insert("g", (int)'g');
        theTree.insert("b", (int)'b');
        theTree.insert("h", (int)'h');
        theTree.insert("a", (int)'a');
        theTree.insert("e", (int)'e');
        theTree.insert("f", (int)'f');
        theTree.insert("c", (int)'c');
        theTree.insert("d", (int)'d');

        theTree.delete("g");

        AtomicInteger count = new AtomicInteger(0);
        showGenericKeyTree(theTree.getRoot(), count);
        System.out.println("Count: " + count);
    }

    private static void showGenericKeyTree(GenericKeyNode<String, Integer> node, AtomicInteger count) {

        GenericKeyNode<String, Integer> leftNode = node.getLeft();
        GenericKeyNode<String, Integer> rightNode = node.getRight();

        System.out.println(node);
        count.incrementAndGet();

        if (leftNode != null) {
            showGenericKeyTree(leftNode, count);
        }

        if (rightNode != null) {
            showGenericKeyTree(rightNode, count);
        }
    }

    /**
     * Measure time.
     */
    public static void testSearchTime() {

        System.out.println("\n>>> test trees time for " + COUNT + " items (ns)");

        System.out.println("\n--- Add");
        times = new long[4];
        for (int i = 0; i < SHOTS; i++) {
            initTrees();
            measureAddTime();
        }
        showTime();

        System.out.println("\n--- Search");
        times = new long[4];
        for (int i = 0; i < SHOTS; i++) {
            measureSearchTime();
        }
        showTime();

        System.out.println("\n--- Delete");
        times = new long[4];
        for (int i = 0; i < SHOTS; i++) {
            measureDeleteTime();
        }
        showTime();
    }

    private static void initTrees() {
        treeMap = new TreeMap<>();
        hashMap = new HashMap<>();
        myGenTree = new GenericKeyTree<>();
        myIntTree = new Tree<>();
    }

    private static void showTime() {
        System.out.println(" treeMap    : " + times[0] / SHOTS);
        System.out.println(" hashMap    : " + times[1] / SHOTS);
        System.out.println(" myGenTree  : " + times[2] / SHOTS);
        System.out.println(" myIntTree  : " + times[3] / SHOTS);
    }

    private static void measureAddTime() {

        long start = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            treeMap.put(rand.nextInt(COUNT), rand.nextInt(COUNT));
        }
        long end = System.nanoTime();
        times[0] += end - start;

        start = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            hashMap.put(rand.nextInt(COUNT), rand.nextInt(COUNT));
        }
        end = System.nanoTime();
        times[1] += end - start;

        start = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            myGenTree.insert(rand.nextInt(COUNT), rand.nextInt(COUNT));
        }
        end = System.nanoTime();
        times[2] += end - start;

        start = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            myIntTree.insert(rand.nextInt(COUNT), rand.nextInt(COUNT));
        }
        end = System.nanoTime();
        times[3] += end - start;
    }

    private static void measureSearchTime() {

        long start = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            treeMap.get(rand.nextInt(COUNT));
        }
        long end = System.nanoTime();
        times[0] += end - start;

        start = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            hashMap.get(rand.nextInt(COUNT));
        }
        end = System.nanoTime();
        times[1] += end - start;

        start = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            myGenTree.find(rand.nextInt(COUNT));
        }
        end = System.nanoTime();
        times[2] += end - start;

        start = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            myIntTree.find(rand.nextInt(COUNT));
        }
        end = System.nanoTime();
        times[3] += end - start;
    }

    private static void measureDeleteTime() {

        long start = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            treeMap.remove(rand.nextInt(COUNT));
        }
        long end = System.nanoTime();
        times[0] += end - start;

        start = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            hashMap.remove(rand.nextInt(COUNT));
        }
        end = System.nanoTime();
        times[1] += end - start;

        start = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            myGenTree.delete(rand.nextInt(COUNT));
        }
        end = System.nanoTime();
        times[2] += end - start;

        start = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            myIntTree.delete(rand.nextInt(COUNT));
        }
        end = System.nanoTime();
        times[3] += end - start;
    }

}
