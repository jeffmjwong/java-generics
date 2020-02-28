package com.pluralsight.generics;

public class Main {
    public static void main(String[] args) {
//        useCircularBuffer();
        Person p1 = new Person("Arthur Lee", 29);
        System.out.println(p1.getName());
        System.out.println(p1.getAge());
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
