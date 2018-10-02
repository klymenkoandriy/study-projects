package com.sigmaukraine.aklymenko.bench.collections.stack;

import com.sigmaukraine.aklymenko.bench.collections.stack.MyStack;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Andriy Klymenko
 */
public class MyStackTest {

    @Test
    public void should_work() {

        MyStack<Integer> stack = new MyStack<>(3);

        assertEquals(true, stack.isEmpty());

        stack.push(1);
        assertEquals(false, stack.isEmpty());
        assertEquals(false, stack.isFull());
        assertEquals(1, stack.peek().intValue());

        stack.push(2);
        assertEquals(2, stack.peek().intValue());

        stack.push(3);
        assertEquals(3, stack.peek().intValue());
        assertEquals(true, stack.isFull());

        assertEquals(3, stack.pop().intValue());
        assertEquals(false, stack.isFull());
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception() {
        new MyStack<>(-1);
    }

}
