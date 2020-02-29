package com.pluralsight.generics;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        useCircularBuffer();
        Person p1 = new Person("Arthur Lee", 29);
        Person p2 = new Person("Saw Kah Chun", 30);
        Person p3 = new Person("Chan", 28);
        Map<String, Person> map1 = new HashMap<>();
        map1.put(p1.getName(), p1);
        map1.put(p2.getName(), p2);
        map1.put(p3.getName(), p3);

        map1.forEach((string, person) -> System.out.println(string + " is " + person + "!"));
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
