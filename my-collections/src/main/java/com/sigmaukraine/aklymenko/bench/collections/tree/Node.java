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

    public Node() {

    }

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
        return "Node { key:{ " + key + "}, value: {" + value + "}";
    }
}
