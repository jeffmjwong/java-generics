package com.pluralsight.generics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.List;

public class PersonLoader {
    private final RandomAccessFile file;

    public PersonLoader(final File file) throws FileNotFoundException {
        this.file = new RandomAccessFile(file, "rw");
    }

    public Person load() throws ClassNotFoundException {
        return new Person("Bob", 20);
    }

    public void loadAll(final List<? super Person> people) throws ClassNotFoundException {
        Person person;
        while ((person = load()) != null) {
            people.add(person);
        }
    }
}
