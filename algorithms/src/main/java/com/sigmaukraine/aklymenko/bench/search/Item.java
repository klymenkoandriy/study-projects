package com.sigmaukraine.aklymenko.bench.search;

/**
 * Item.
 * 
 * @author Andriy Klymenko
 *
 */
public class Item implements Comparable<Item> {

    private int key;
    private String value;

    /**
     * Default constructor.
     */
    public Item() {
    }

    /**
     * Constructor.
     * 
     * @param key key
     * @param value value
     */
    public Item(int key, String value) {
        super();
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

    @Override
    public String toString() {
        return "Item [key=" + key + ", value=" + value + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + key;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        Item other = (Item) obj;
        if (key != other.key) {
            return false;
        }
        if (value == null) {
            if (other.value != null) {
                return false;
            }
        } else if (!value.equals(other.value)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Item o) {
        return this.key - o.key;
    }



}
