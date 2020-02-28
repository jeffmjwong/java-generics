package com.pluralsight.generics;

public class Main {
    public static void main(String[] args) {
        final CircularBuffer buffer = new CircularBuffer(10);

        buffer.offer("a");
        buffer.offer("bc");
        buffer.offer("d");

        String value = concatenate(buffer);
        System.out.println(value);
    }

    private static String concatenate(CircularBuffer buffer) {
        StringBuilder builder = new StringBuilder();
        String value;

        while ((value = (String) buffer.poll()) != null) {
            builder.append(value);
        }

        return builder.toString();
    }
}
