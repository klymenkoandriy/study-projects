package com.sigmaukraine.aklymenko.bench.collections.queue;

/**
 * @author Andriy Klymenko
 */
public final class TryQueue {

    private TryQueue() {
    }

    /**
     * MySimpleQueue manual test.
     */
    public static void tryMySimpleQueue() {

        System.out.println(">>> test Queue");

        MySimpleQueue<Integer> queue = new MySimpleQueue<>();

        System.out.println("size:" + queue.size());

        queue.add(0);
        System.out.println("add");
        System.out.println("size:" + queue.size());

        queue.add(1);
        System.out.println("add");
        System.out.println("size:" + queue.size());

        queue.poll();
        System.out.println("poll");
        System.out.println("size:" + queue.size());

        queue.poll();
        System.out.println("poll");
        System.out.println("size:" + queue.size());
    }
}
