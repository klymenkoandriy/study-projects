package com.sigmaukraine.aklymenko.bench.collections.tree;

/**
 * @author Andriy Klymenko
 */
public class Tree<E> {

    private Node<E> root;

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

    public void insert(int id, E value) {
        Node<E> newNode = new Node<>(id, value);

        if (root == null) {
            root = newNode;
        } else {
            Node<E> current = root;
            Node<E> parent;
            while (true) {
                parent = current;
                if (id < current.getKey()) {
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
            // Delete if no children
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                    parent.setLeft(null);
                }  else {
                    parent.setRight(null);
                }
        } else if (current.getRight() == null) {
            // If no right child then replace by left subtree
            if (current == root) {
                root = current.getLeft();
            } else if (isLeftChild) {
                parent.setLeft(current.getLeft());
            } else {
                parent.setRight(current.getLeft());
            }
        } else if (current.getLeft() == null) {
            // If no left child then replace by right subtree
            if (current == root) {
                root = current.getRight();
            } else if (isLeftChild) {
                parent.setLeft(current.getRight());
            } else {
                parent.setRight(current.getRight());
            }
        } else {
            // If there are two children, replace by successor
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


        return true;
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
}
