package com.sigmaukraine.aklymenko.bench.collections.queue;

import com.sigmaukraine.aklymenko.bench.collections.queue.MySimpleQueue;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Andriy Klymenko
 */
public class MySimpleQueueTest {

    private static Integer[] data;

    @BeforeClass
    public static void init() {

        data = new Integer[7];

        for (int i = 0 ; i < data.length; i++) {
            data[i] = (i + 1) * 11;
        }
    }

    @Test
    public void should_work_my() {
        MySimpleQueue<Integer> queue = new MySimpleQueue<>();

        assertEquals(true, queue.isEmpty());

        for (Integer value : data) {
            queue.add(value);
        }

        assertEquals(data.length, queue.size());

        assertEquals(data[0].intValue(), queue.peek().intValue());
        assertEquals(7, queue.size());

        assertEquals(data[0].intValue(), queue.poll().intValue());
        assertEquals(data[1].intValue(), queue.poll().intValue());

        assertEquals(5, queue.size());
        assertEquals(false, queue.isEmpty());

        queue.clear();
        assertEquals(0, queue.size());
        assertEquals(true, queue.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception() {
        new MySimpleQueue<>(-1);
    }

    @Test
    public void should_increase_capacity() {

        MySimpleQueue<Integer> queue = new MySimpleQueue<>(2);

        for (Integer value : data) {
            queue.add(value);
        }

        assertEquals(7, queue.size());
    }
}
