package com.pluralsight.generics;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.File;

public class PersonStorageTest {
    private Partner matt = new Partner("Matt", 57);
    private Partner nick = new Partner("Nick", 53);
    private Employee mike = new Employee("Mike", 39);

    private File file;
    private PersonSaver saver;
    private PersonLoader loader;

    @Test
    public void savesAndLoadPerson() throws Exception {
        Person person = new Person("Bob", 20);
        saver.save(matt);
        saver.save(mike);

        assertEquals(person, loader.load());
    }
}
