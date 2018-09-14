package com.sigmaukraine.aklymenko.bench;

import com.sigmaukraine.aklymenko.bench.collections.queue.MySimpleQueue;
import com.sigmaukraine.aklymenko.bench.collections.tree.Node;
import com.sigmaukraine.aklymenko.bench.collections.tree.Tree;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Andriy Klymenko
 */
public class MainCollections {

    /**
     * Main.
     *
     * @param args arguments
     */
    public static void main(String[] args) {
        //tryMySimpleQueue();
        tryTree();
    }

     private static void tryMySimpleQueue() {
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

        String leftKey = leftNode == null ? "" : String.valueOf(leftNode.getKey());
        String rightKey = rightNode == null ? "" : String.valueOf(rightNode.getKey());

        System.out.println("Node {key: " + node.getKey() + ", left: " + leftKey + ", right: " + rightKey + "}");
        count.incrementAndGet();

        if (leftNode != null) {
            showTree(leftNode, count);
        }

        if (rightNode != null) {
            showTree(rightNode, count);
        }
    }
}
