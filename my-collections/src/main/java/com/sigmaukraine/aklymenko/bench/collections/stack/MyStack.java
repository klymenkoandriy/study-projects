package com.sigmaukraine.aklymenko.bench.collections.stack;

/**
 * Stack implementation.
 *
 * @author Andriy Klymenko
 * @param <E> type
 */
public class MyStack<E> {

    private static final int INITIAL_CAPACITY = 8;

    private Object[] elements;
    private int maxSize;
    private int top;

    public MyStack() {
        this(INITIAL_CAPACITY);
    }

    public MyStack(int k) {
        if (k <= 0) {
            throw new IllegalArgumentException();
        }

        elements = new Object[k];
        maxSize = k;
        top = -1;
    }

    public void push(E value) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }

        elements[++top] = value;
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        return isEmpty() ? null : (E) elements[top--];
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        return isEmpty() ? null : (E) elements[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }
}
