package com.pluralsight.generics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class PersonSaver {
    private final RandomAccessFile file;

    public PersonSaver(final File file) throws FileNotFoundException {
        this.file = new RandomAccessFile(file, "rw");
    }

    public boolean save(Person person) throws IOException {
        return true;
    }

    public boolean saveAll(Person[] persons) throws IOException {
        for (Person person : persons) {
            save(person);
        }

        return true;
    }
}
