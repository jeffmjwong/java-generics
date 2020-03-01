package com.pluralsight.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        useCircularBuffer();
        Person p1 = new Person("Arthur Lee", 29);
        Person p2 = new Person("Saw Kah Chun", 30);
        Person p3 = new Person("Chan", 28);

        List<Person> list1 = new ArrayList<>(Arrays.asList(p1, p2, p3));

        final Person youngestPerson = (Person) min(list1, new AgeComparator());

        System.out.println(youngestPerson);
    }

    private static Object min(List list, Comparator comparator) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List is empty, cannot find minimum!");
        }

        Object lowestElement = list.get(0);

        for (Object element : list) {
            if (comparator.compare(element, lowestElement) < 0) {
                lowestElement = element;
            }
        }

        return lowestElement;
    }

    private static void useCircularBuffer() {
        final CircularBuffer<String> buffer = new CircularBuffer<>(10);

        buffer.offer("a");
        buffer.offer("bc");
        buffer.offer("d");

        String value = concatenate(buffer);
        System.out.println(value);
    }

    private static String concatenate(CircularBuffer<String> buffer) {
        StringBuilder builder = new StringBuilder();
        String value;

        while ((value = buffer.poll()) != null) {
            builder.append(value);
        }

        return builder.toString();
    }
}
