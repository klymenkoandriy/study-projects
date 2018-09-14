package com.sigmaukraine.aklymenko.bench.collections.stack;

import com.sigmaukraine.aklymenko.bench.collections.stack.BracketCheckerUtil;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Andriy Klymenko
 */
public class BracketCheckerUtilTest {

    @Test
    public void should_check_string() {
        assertTrue(BracketCheckerUtil.check("{a[z(x)c]v}"));
        assertFalse(BracketCheckerUtil.check("]"));
    }
}
