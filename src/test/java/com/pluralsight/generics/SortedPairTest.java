package com.pluralsight.generics;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SortedPairTest {
    @Test
    public void shouldRetainOrderOfOrderedPair() {
        SortedPair<Integer> sp = new SortedPair<>(1, 2);

        assertEquals(1, sp.getFirst().intValue());
        assertEquals(2, sp.getSecond().intValue());
    }

    @Test
    public void shouldFlipOrderOfMisorderedPair() {
        SortedPair<Integer> sp = new SortedPair<>(2, 1);

        assertEquals(1, sp.getFirst().intValue());
        assertEquals(2, sp.getSecond().intValue());
    }
}
