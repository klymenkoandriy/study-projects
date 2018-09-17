package com.sigmaukraine.aklymenko.bench;

import com.sigmaukraine.aklymenko.bench.collections.list.TryList;
import com.sigmaukraine.aklymenko.bench.collections.queue.MySimpleQueue;
import com.sigmaukraine.aklymenko.bench.collections.tree.Node;
import com.sigmaukraine.aklymenko.bench.collections.tree.Tree;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Andriy Klymenko
 */
public final class MainCollections {

    private MainCollections() {
    }

    /**
     * Main.
     *
     * @param args arguments
     */
    public static void main(String[] args) {
        tryMySimpleQueue();
        tryTree();
        TryList.compareLists();
    }

     private static void tryMySimpleQueue() {

         System.out.println(">>> test Queue");

         MySimpleQueue<Integer> queue = new MySimpleQueue<>();

         System.out.println("size:" + queue.size());

         queue.add(0);
         System.out.println("add");
         System.out.println("size:" + queue.size());

         queue.add(1);
         System.out.println("add");
         System.out.println("size:" + queue.size());

         queue.poll();
         System.out.println("poll");
         System.out.println("size:" + queue.size());

         queue.poll();
         System.out.println("poll");
         System.out.println("size:" + queue.size());
    }

    private static void tryTree() {
        System.out.println("\n>>> test Tree");

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
        showTree(theTree.getRoot(), count);
        System.out.println("Count: " + count);
    }

    private static void showTree(Node node, AtomicInteger count) {

        Node leftNode = node.getLeft();
        Node rightNode = node.getRight();

        System.out.println(node);
        count.incrementAndGet();

        if (leftNode != null) {
            showTree(leftNode, count);
        }

        if (rightNode != null) {
            showTree(rightNode, count);
        }
    }
}
