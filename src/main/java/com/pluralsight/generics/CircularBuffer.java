package com.pluralsight.generics;

public class CircularBuffer {
    private Object[] objects;
    private int readCursor = 0;
    private int writeCursor = 0;

    public CircularBuffer(int size) {
        this.objects = new Object[size];
    }

    public boolean offer(Object obj) {
        if (objects[writeCursor] != null) {
            return false;
        }

        objects[writeCursor] = obj;
        writeCursor = next(writeCursor);
        return true;
    }

    public Object poll() {
        Object currentObject = objects[readCursor];

        if (currentObject != null) {
            objects[readCursor] = null;
            readCursor = next(readCursor);
        }

        return currentObject;
    }

    private int next(int index) {
        return (index + 1) % objects.length;
    }
}
