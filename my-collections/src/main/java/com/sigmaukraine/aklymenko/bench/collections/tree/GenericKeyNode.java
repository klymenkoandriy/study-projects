package com.sigmaukraine.aklymenko.bench.collections.tree;

/**
 * Node with generic in key.
 *
 * @author Andriy Klymenko
 *
 * @param <K> key type
 * @param <E> value type
 */
public class GenericKeyNode<K extends Comparable<K>, E> {

    private K key;
    private E value;
    private GenericKeyNode<K, E> left;
    private GenericKeyNode<K, E> right;

    /**
     * Default constructor.
     */
    public GenericKeyNode() {
    }

    /**
     * Constructor.
     *
     * @param key key
     * @param value value
     */
    public GenericKeyNode(K key, E value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public GenericKeyNode<K, E> getLeft() {
        return left;
    }

    public void setLeft(GenericKeyNode<K, E> left) {
        this.left = left;
    }

    public GenericKeyNode<K, E> getRight() {
        return right;
    }

    public void setRight(GenericKeyNode<K, E> right) {
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
