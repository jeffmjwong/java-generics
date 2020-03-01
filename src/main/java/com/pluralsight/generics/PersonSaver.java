package com.pluralsight.generics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public class PersonSaver {
    private final RandomAccessFile file;

    public PersonSaver(final File file) throws FileNotFoundException {
        this.file = new RandomAccessFile(file, "rw");
    }

    public boolean save(Person person) throws IOException {
        return true;
    }

    public <T extends Person> boolean saveAll(List<T> persons) throws IOException {
        for (Person person : persons) {
            save(person);
        }

        return true;
    }
}
