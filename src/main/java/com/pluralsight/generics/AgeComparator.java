package com.pluralsight.generics;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(final Person p1, final Person p2) {
        return Integer.compare(p2.getAge(), p1.getAge());
    }
}
