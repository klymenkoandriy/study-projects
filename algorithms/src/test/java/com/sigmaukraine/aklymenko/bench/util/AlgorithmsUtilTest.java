package com.sigmaukraine.aklymenko.bench.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AlgorithmsUtilTest {

    @Test
    public void should_check_bit_in_position() {
        int value = 0b00100101;
        assertTrue(AlgorithmsUtil.isBitSet(value, 0));
        assertFalse(AlgorithmsUtil.isBitSet(value, 1));
        assertTrue(AlgorithmsUtil.isBitSet(value, 2));
        assertFalse(AlgorithmsUtil.isBitSet(value, 3)); 
    }
}
