package com.sigmaukraine.aklymenko.bench.collections.tree;

/**
 * Binary tree that uses a generic key.
 *
 * @author Andriy Klymenko
 *
 * @param <K> key type
 * @param <E> value type
 */
public class GenericKeyTree<K extends Comparable<K>, E> {

    private GenericKeyNode<K, E> root;

    /**
     * Returns value by key.
     *
     * @param key key
     * @return value
     */
    public E find(K key) {
        GenericKeyNode<K, E> current = root;
        while (!current.getKey().equals(key)) {
            if (key.compareTo(current.getKey()) < 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
            if (current == null) {
                return null;
            }
        }
        return current.getValue();
    }

    /**
     * Inserts new value by key.
     *
     * @param key key
     * @param value value
     */
    public void insert(K key, E value) {
        GenericKeyNode<K, E> newNode = new GenericKeyNode<>(key, value);

        if (root == null) {
            root = newNode;
        } else {
            GenericKeyNode<K, E> current = root;
            GenericKeyNode<K, E> parent;
            while (true) {
                parent = current;
                if (key.compareTo(current.getKey()) < 0) {
                    current = current.getLeft();
                    if (current == null) {
                        parent.setLeft(newNode);
                        return;
                    }
                } else {
                    current = current.getRight();
                    if (current == null) {
                        parent.setRight(newNode);
                        return;
                    }
                }
            }
        }
    }

    /**
     * Deletes value by key.
     *
     * @param key key
     * @return <code>true</code> if deleting is successful, otherwise <code>false</code>
     */
    public boolean delete(K key) {
        GenericKeyNode<K, E> current = root;
        GenericKeyNode<K, E> parent = root;
        boolean isLeftChild = true;

        while (!current.getKey().equals(key)) {
            parent = current;
            if (key.compareTo(current.getKey()) < 0) {
                isLeftChild = true;
                current = current.getLeft();
            } else {
                isLeftChild = false;
                current = current.getRight();
            }
            if (current == null) {
                return false;
            }
        }

        if (current.getLeft() == null && current.getRight() == null) {
            deleteIfNoChildren(current, parent, isLeftChild);
        } else if (current.getRight() == null) {
            replaceIfNoRightChild(current, parent, isLeftChild);
        } else if (current.getLeft() == null) {
            replaceIfNoLeftChild(current, parent, isLeftChild);
        } else {
            replaceIfTwoChildren(current, parent, isLeftChild);
        }

        return true;
    }

    private void deleteIfNoChildren(GenericKeyNode<K, E> current, GenericKeyNode<K, E> parent, boolean isLeftChild) {
        if (current == root) {
            root = null;
        } else if (isLeftChild) {
            parent.setLeft(null);
        }  else {
            parent.setRight(null);
        }
    }

    private void replaceIfNoRightChild(GenericKeyNode<K, E> current, GenericKeyNode<K, E> parent, boolean isLeftChild) {
        if (current == root) {
            root = current.getLeft();
        } else if (isLeftChild) {
            parent.setLeft(current.getLeft());
        } else {
            parent.setRight(current.getLeft());
        }
    }

    private void replaceIfNoLeftChild(GenericKeyNode<K, E> current, GenericKeyNode<K, E> parent, boolean isLeftChild) {
        if (current == root) {
            root = current.getRight();
        } else if (isLeftChild) {
            parent.setLeft(current.getRight());
        } else {
            parent.setRight(current.getRight());
        }
    }

    private void replaceIfTwoChildren(GenericKeyNode<K, E> current, GenericKeyNode<K, E> parent, boolean isLeftChild) {
        GenericKeyNode<K, E> successor = getSuccessor(current);

        if (current == root) {
            root = successor;
        } else if (isLeftChild) {
            parent.setLeft(successor);
        } else {
            parent.setRight(successor);
        }

        successor.setLeft(current.getLeft());
    }

    private GenericKeyNode<K, E> getSuccessor(GenericKeyNode<K, E> delNode) {
        GenericKeyNode<K, E> successorParent = delNode;
        GenericKeyNode<K, E> successor = delNode;
        GenericKeyNode<K, E> current = delNode.getRight();
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeft();
        }

        if (successor != delNode.getRight()) {
            successorParent.setLeft(successor.getRight());
            successor.setRight(delNode.getRight());
        }
        return successor;
    }

    public GenericKeyNode<K, E> getRoot() {
        return root;
    }
}
