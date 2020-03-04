package com.pluralsight.generics;

import java.util.HashMap;
import java.util.Map;

public class Injector {
    private Map<Class<?>, Object> objectGraph = new HashMap<>();

    public Injector with(final Object value) {
        objectGraph.put(value.getClass(), value);
        return this;
    }

    public Map<Class<?>, Object> getObjectGraph() {
        return objectGraph;
    }

    public Object newInstance(final Class<?> className) {
        return null;
    }
}
