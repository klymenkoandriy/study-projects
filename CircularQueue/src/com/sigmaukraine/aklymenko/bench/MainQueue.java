package com.sigmaukraine.aklymenko.bench;

/**
 * @author Andriy Klymenko
 */
public class MainQueue {

    public static void main(String[] args) {

        MyCircularQueue queue = new MyCircularQueue(3);

        int item = 11;

        while (queue.isFull() == false) {
            queue.enQueue(item++);
            System.out.println("write: " + queue.rear());
        }

        System.out.println("");

        while (queue.isEmpty() == false) {
            System.out.println("read:  " + queue.front());
            queue.deQueue();
        }

    }
}
