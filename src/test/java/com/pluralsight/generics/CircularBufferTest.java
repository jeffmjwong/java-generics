package com.pluralsight.generics;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class CircularBufferTest {
    private CircularBuffer<Integer> buffer = new CircularBuffer<>(2);

    @Test
    public void shouldOfferPollableElement() {
        assertTrue(buffer.offer(1));
        assertEquals(Optional.of(1).get(), buffer.poll());
        assertNull(buffer.poll());
    }

    @Test
    public void shouldNotOfferWhenBufferIsFull() {
        assertTrue(buffer.offer(1));
        assertTrue(buffer.offer(2));
        assertFalse(buffer.offer(3));
    }

    @Test
    public void shouldNotPollWhenBufferIsEmpty() {
        assertNull(buffer.poll());
    }

    @Test
    public void shouldRecycleBuffer() {
        assertTrue(buffer.offer(1));
        assertTrue(buffer.offer(2));
        assertEquals(Optional.of(1).get(), buffer.poll());
        assertTrue(buffer.offer(3));
        assertEquals(Optional.of(2).get(), buffer.poll());
        assertEquals(Optional.of(3).get(), buffer.poll());
    }
}
