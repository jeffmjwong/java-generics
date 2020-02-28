package com.pluralsight.generics;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class CircularBufferTest {
    private CircularBuffer buffer = new CircularBuffer(2);

    @Test
    public void shouldOfferPollableElement() {
        assertTrue(buffer.offer(1));
        assertEquals(1, buffer.poll());
        assertNull(buffer.poll());
    }

    @Test
    public void shouldNotOfferWhenBufferIsFull() {
        assertTrue(buffer.offer(1));
        assertTrue(buffer.offer(2));
        assertFalse(buffer.offer(3));
    }
}
