package com.pluralsight.generics;

public class SortedPair<T> {
    private T first;
    private T second;

    public SortedPair(T t1, T t2) {
        first = t1;
        second = t2;
    }
}
