package com.pluralsight.generics;

public class SortedPair<T> {
    private final T first;
    private final T second;

    public SortedPair(T t1, T t2) {
        first = t1;
        second = t2;
    }

    public T getFirst() {
        return first;
    }
    public T getSecond() {
        return second;
    }
}
