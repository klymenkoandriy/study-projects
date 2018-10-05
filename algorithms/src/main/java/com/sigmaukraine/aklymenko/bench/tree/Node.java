package com.sigmaukraine.aklymenko.bench.tree;

/**
 * 
 * @author Andriy Klymenko
 *
 */
public class Node {
    private int key;
    private String value;
    private Node zeroNode;
    private Node oneNode;

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
    public Node(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getZeroNode() {
        return zeroNode;
    }

    public void setZeroNode(Node zeroNode) {
        this.zeroNode = zeroNode;
    }

    public Node getOneNode() {
        return oneNode;
    }

    public void setOneNode(Node oneNode) {
        this.oneNode = oneNode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Node {key:");
        sb.append(key);
        sb.append(", value:");
        sb.append(value);

        sb.append(", <0>:{");
        if (zeroNode != null) {
            sb.append("key:");
            sb.append(zeroNode.getKey());
        }

        sb.append("}, <1>:{");
        if (oneNode != null) {
            sb.append("key:");
            sb.append(oneNode.getKey());
        }
        sb.append("}}");

        return sb.toString();
    }
}
