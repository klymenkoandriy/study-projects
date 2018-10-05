package com.sigmaukraine.aklymenko.bench.tree;

import com.sigmaukraine.aklymenko.bench.util.AlgorithmsUtil;

/**
 * 
 * @author Andriy Klymenko
 *
 */
public class DigitalSearchTree {

    private Node root;
    private int size;

    public int getSize() {
        return size;
    }

    /**
     * Returns Node by key.
     *
     * @param key key
     * @return node
     */
    public String find(int key) {
        if (root == null) {
            return null;
        }

        if (root.getKey() == key) {
            return root.getValue();
        }

        int bitPos = 0;
        Node current = root;

        while (current.getKey() != key) {
            if (AlgorithmsUtil.isBitSet(key, bitPos)) {
                current = current.getOneNode();
            } else {
                current = current.getZeroNode();
            }
            if (current == null) {
                return null;
            }
            bitPos++;
        }

        return current.getValue();
    }

    /**
     * Adds node with given key and value.
     *
     * @param key   key
     * @param value value
     */
    public void insert(int key, String value) {
        size++;
        Node newNode = new Node(key, value);

        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            int bitPos = 0;
            Node parent;
            while (true) {
                parent = current;
                if (AlgorithmsUtil.isBitSet(key, bitPos)) {
                    current = current.getOneNode();
                    if (current == null) {
                        parent.setOneNode(newNode);
                        break;
                    }
                } else {
                    current = current.getZeroNode();
                    if (current == null) {
                        parent.setZeroNode(newNode);
                        break;
                    }
                }
                bitPos++;
            }
        }
    }

    public Node getRoot() {
        return root;
    }

}
