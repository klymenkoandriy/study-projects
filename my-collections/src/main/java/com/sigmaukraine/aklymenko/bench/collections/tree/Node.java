package com.sigmaukraine.aklymenko.bench.collections.tree;

/**
 * @author Andriy Klymenko
 * @param <E> type
 */
public class Node<E> {

    private int key;
    private E value;
    private Node<E> left;
    private Node<E> right;

    /**
     * Default constructor.
     */
    public Node() {
    }

    /**
     * Constructor.
     *
     * @param key key
     * @param value value
     */
    public Node(int key, E value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Node {key:");
        sb.append(key);
        sb.append(", value:");
        sb.append(value);

        sb.append(", left:{");
        if (left != null) {
            sb.append("key:");
            sb.append(left.getKey());
        }

        sb.append("}, right:{");
        if (right != null) {
            sb.append("key:");
            sb.append(right.getKey());
        }
        sb.append("}}");

        return sb.toString();
    }
}
