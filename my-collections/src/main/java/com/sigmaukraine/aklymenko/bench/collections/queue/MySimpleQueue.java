package com.sigmaukraine.aklymenko.bench.collections.queue;

/**
 * The queue implementation.
 *
 * @author Andriy Klymenko
 * @param <E> the type
 */
public class MySimpleQueue<E> {

    private static final int INITIAL_CAPACITY = 8;

    private Object[] elements;

    private int head;

    private int tail;

    private int size;

    /**
     * Constructor with size.
     *
     * @param k initial size
     */
    public MySimpleQueue(int k) {
        if (k <= 0) {
            throw new IllegalArgumentException();
        }

        elements = new Object[k];
        head = -1;
        tail = -1;
    }

    /**
     * Default constructor.
     */
    public MySimpleQueue() {
        this(INITIAL_CAPACITY);
    }

    /**
     * Returns size.
     *
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * Checks whether the queue is empty or not.
     *
     * @return <code>true</code> if empty
     */
    public boolean isEmpty() {
        return head == -1;
    }

    /**
    * Checks whether the queue is full or not.
    *
    * @return <code>true</code> if full
    */
    public boolean isFull() {
        return ((tail + 1) % elements.length) == head;
    }

    /**
     * Inserts the specified element into this queue if it is possible to do
     * so immediately without violating capacity restrictions.
     *
     * @param value value
     */
    public void add(E value) {
        if (isFull()) {
            doubleCapacity();
        }

        if (isEmpty()) {
            head = 0;
        }

        tail = (tail + 1) % elements.length;
        size++;
        elements[tail] = value;
    }

    private void doubleCapacity() {
        int p = head;
        int n = elements.length;
        int r = n - p;
        int newCapacity = n << 1;

        if (newCapacity < 0) {
            throw new IllegalStateException("Que too big");
        }

        Object[] a = new Object[newCapacity];
        System.arraycopy(elements, p, a, 0, r);
        System.arraycopy(elements, 0, a, r, p);
        elements = a;
        head = 0;
        tail = n - 1;
    }

    /**
     * Clears queue.
     */
    public void clear() {

        if (!isEmpty()) {
            for (int i = 0; i < elements.length; i++) {
                elements[i] = null;
            }
        }

        tail = -1;
        head = tail;
        size = 0;
    }

    /**
     * Retrieves and removes the head of this queue,
     * or returns <code>null</code> if this queue is empty.
     *
     * @return value
     */
    public E poll() {
        E result = peek();

        head = (head + 1) % elements.length;
        size--;
        if (size == 0) {
            head = -1;
            tail = -1;
        }

        return result;
    }

    /**
     * Retrieves, but does not remove, the head of this queue,
     * or returns <code>null</code> if this queue is empty.
     *
     * @return value
     */
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) elements[head];
    }

}
