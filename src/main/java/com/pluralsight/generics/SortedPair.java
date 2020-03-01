package com.pluralsight.generics;

public class SortedPair<T extends Comparable<T>> {
    private final T first;
    private final T second;

    public SortedPair(T t1, T t2) {
        if (t1.compareTo(t2) < 0) {
            first = t1;
            second = t2;
        } else {
            first = t2;
            second = t1;
        }
    }

    public T getFirst() {
        return first;
    }
    public T getSecond() {
        return second;
    }

}
