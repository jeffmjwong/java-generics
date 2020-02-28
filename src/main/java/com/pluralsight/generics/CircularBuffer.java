package com.pluralsight.generics;

public class CircularBuffer {
    private Object[] buffer;
    private int readCursor = 0;
    private int writeCursor = 0;

    public CircularBuffer(int size) {
        buffer = new Object[size];
    }

    public boolean offer(Object value) {
        if (buffer[writeCursor] != null) {
            return false;
        }

        buffer[writeCursor] = value;
        writeCursor = next(writeCursor);
        return true;
    }

    public Object poll() {
        Object currentObject = buffer[readCursor];

        if (currentObject != null) {
            buffer[readCursor] = null;
            readCursor = next(readCursor);
        }

        return currentObject;
    }

    private int next(int index) {
        return (index + 1) % buffer.length;
    }
}
