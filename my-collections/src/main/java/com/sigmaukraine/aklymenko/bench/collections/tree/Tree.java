package com.sigmaukraine.aklymenko.bench.collections.tree;

/**
 * @author Andriy Klymenko
 *
 * @param <E> type
 */
public class Tree<E> {

    private Node<E> root;
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
    public Node find(int key) {
        Node current = root;
         while (current.getKey() != key) {
                if (key < current.getKey()) {
                    current = current.getLeft();
                } else {
                    current = current.getRight();
                }
                if (current == null) {
                    return null;
                }
            }
            return current;
    }

    /**
     * Adds node with given key and value.
     *
     * @param key key
     * @param value value
     */
    public void insert(int key, E value) {
        size++;
        Node<E> newNode = new Node<>(key, value);

        if (root == null) {
            root = newNode;
        } else {
            Node<E> current = root;
            Node<E> parent;
            while (true) {
                parent = current;
                if (key < current.getKey()) {
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
     * Deletes node by key.
     *
     * @param key key
     * @return <code>true</code> if deletion is successful, otherwise <code>false</code>
     */
    public boolean delete(int key) {
        Node<E> current = root;
        Node<E> parent = root;
        boolean isLeftChild = true;

        while (current.getKey() != key) {
            parent = current;
            if (key < current.getKey()) {
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

        size--;
        return true;
    }

    private void deleteIfNoChildren(Node<E> current, Node<E> parent, boolean isLeftChild) {
        if (current == root) {
            root = null;
        } else if (isLeftChild) {
            parent.setLeft(null);
        }  else {
            parent.setRight(null);
        }
    }

    private void replaceIfNoRightChild(Node<E> current, Node<E> parent, boolean isLeftChild) {
        if (current == root) {
            root = current.getLeft();
        } else if (isLeftChild) {
            parent.setLeft(current.getLeft());
        } else {
            parent.setRight(current.getLeft());
        }
    }

    private void replaceIfNoLeftChild(Node<E> current, Node<E> parent, boolean isLeftChild) {
        if (current == root) {
            root = current.getRight();
        } else if (isLeftChild) {
            parent.setLeft(current.getRight());
        } else {
            parent.setRight(current.getRight());
        }
    }

    private void replaceIfTwoChildren(Node<E> current, Node<E> parent, boolean isLeftChild) {
        Node<E> successor = getSuccessor(current);

        if (current == root) {
            root = successor;
        } else if (isLeftChild) {
            parent.setLeft(successor);
        } else {
            parent.setRight(successor);
        }

        successor.setLeft(current.getLeft());
    }


    private Node<E> getSuccessor(Node<E> delNode) {
        Node<E> successorParent = delNode;
        Node<E> successor = delNode;
        Node<E> current = delNode.getRight();
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


    public Node<E> getRoot() {
        return root;
    }

    /**
     * Returns sorted keys.
     *
     * @return sorted keys
     */
    public int[] getSortedKeys() {
        int[] results = new int[size];
        inOrder(getRoot(), results, 0);
        return results;
    }

    private int inOrder(Node<E> root, int[] results, int indexArg) {
        int index = indexArg;
        if (root.getLeft() != null) {
            index = inOrder(root.getLeft(), results, index);
        }

        results[index] = root.getKey();
        index++;

        if (root.getRight() != null) {
            index = inOrder(root.getRight(), results, index);
        }

        return index;
    }
}
